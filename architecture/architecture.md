## Table of contents

- [Table of contents](#table-of-contents)
- [Data intensive applications](#data-intensive-applications)
- [API problems](#api-problems)
  - [Paginating](#paginating)
    - [Links](#links)
    - [Overview](#overview)
    - [Page — based pagination](#page--based-pagination)
      - [Pros](#pros)
      - [Cons](#cons)
    - [KeySet-based pagination](#keyset-based-pagination)
      - [Pros](#pros-1)
      - [Cons](#cons-1)
    - [Cursor-based pagination](#cursor-based-pagination)
      - [Pros](#pros-2)
      - [Cons](#cons-2)


## Data intensive applications

Many applications today are **data-intensive**, as opposed to **compute-intensive**. Raw CPU power is rarely a limiting factor for these applications—bigger problems are usually the amount of data, the complexity of data, and the speed at which it is changing.

A data-intensive application is typically built from standard building blocks:
- Store data so that they, or another application, can find it again later (databases)
- Remember the result of an expensive operation, to speed up reads (caches)
- Allow users to search data by keyword or filter it in various ways (search indexes)
- Send a message to another process, to be handled asynchronously (stream processing)
- Periodically crunch a large amount of accumulated data (batch processing)

Just an example:

![](images/variant_of_system.png)

## API problems

### Paginating 

#### Links

[Paginating Requests in APIs](https://ignaciochiazzo.medium.com/paginating-requests-in-apis-d4883d4c1c4c)

#### Overview

Multiple names are used in the industry for endpoints that return a paginated set, particularly in REST APIS, such as 
- collection resource
- listing endpoints
-  index endpoints

Before exposing any listing endpoint, we should ask ourselves at least the following questions: 
- Can the list be sorted? 
- Is there any default order? 
- Can the list be filtered? 
- If so, which filter params should it accept? 
- Are the queries, executed under the hood, performant enough? 

Exposing endpoints is very easy. Deprecating and deleting them is extremely hard and potentially impossible.

#### Page — based pagination

This is the simplest and most common form of paging, particularly for Apps that use SQL Databases. The set is divided into pages. The endpoint accepts a page param that is an integer indicating the page within the list to be returned.

![](images/page_base_pagination.webp)

```sql
select *
from products
order by id
limit 20
offset 200;
```

SQL offset skips the first `N` results of the query. Nonetheless, the database will have to fetch the `N` results from the disks and bring them to return the records next to them.

>  …the rows are first sorted according to the order by clause and then limited by dropping the number of rows specified in the result offset clause from the beginning…. .” SQL:2016, Part 2, §4.15.3 Derived tables

##### Pros
- You can jump to any particular page, not needing to query 99 pages to get the page 100.
- It allows sending parallel requests with different pages.
- Stateless on the server-side.
- Easy to understand and debug.
- This approach requires very little business logic. Many libraries are written in different languages that are easy to use.

##### Cons
- Bad performance for large OFFSET in SQL. The database must scan and count N rows when doing OFFSET in SQL.
- It can return repeated or missing if any is added/deleted while paginating. E.g., If the first request asks for page 1 and a new record is inserted to the first page, then the request with page 2 will have a record repeated which was returned on the previous request.

#### KeySet-based pagination

The API provides a key param that acts as a delimiter of the page. This key param should be the same key of the set sort order. For example, if the set is sorted by `ID`, then the key param should be `since_id`. Other examples would be `since_updated_at`, `since_created_at` etc.

![](images/key_based_pagination.webp)

```sql
select *
from products
where ID > since_id
order by ID ASC
limit 100
```

##### Pros

- The SQL query is more efficient than OFFSET (for most cases) since it uses a WHERE condition (assuming it has good SQL indexes).
- Unlike page-based pagination, new records inserted on previous pages won’t cause duplicated elements.
  
##### Cons
- It’s tied to the sort order. If you want to use since_id, the set should be sorted by id.
- There is no way to jump to a specific page. It needs to iterate through all the previous pages.
- It doesn’t allow sending parallel requests for different batches.
- The API needs to expose multiple key-params (e.g. since_id,since_updated_at).
- The client needs to keep track of the key-value of the set.
- Missing items if they are added to the previous pages

#### Cursor-based pagination

Given a set, a cursor will be a piece of data that contains a pointer to an element and the info to get the next/previous elements. The server should return the cursor pointing to the next page in each request

![](images/curson_based_pagination.webp)

The SQL query will depend on the implementation, but it will be similar to the query generated by the KeySet-based Pagination method using a WHERE condition.

There are different approaches to implementing this method. Some return the cursor as part of the payload. Others return the cursor as part of the Header, particularly in the LINK headers. The cursor might contain all the information needed or partially allowing clients to add other filter parameters.

Clients should not store the cursor on their side. Google API Documentation suggests adding an expiration date to the token and expiring cursors sent in requests.

##### Pros

- If the cursor is opaque, the implementation underneath can change without introducing an API change.
- In most cases, it is much faster than using page in SQL since it won’t use OFFSET in the database.
- There is no issue when a record is deleted as opposed to Page-based Pagination.

##### Cons

- There is no way to skip pages. If the user wants page X, it must request pages from 1 to X.
- It doesn’t allow sending parallel requests for different batches.
- The implementation is more complex than LIMIT/OFFSET.
- Hard to debug. Given a request, you have to decode it to debug it.
- Missing items if they are added to the previous pages