# Table of contents

# Errors

## When maven deploy 422 Error

Error:  Failed to execute goal org.apache.maven.plugins:maven-deploy-plugin:2.7:deploy (default-deploy) on project LearningAWSLambdas: Failed to deploy artifacts: Could not transfer artifact org.example:LearningAWSLambdas:jar:1.0-20230313.140533-1 from/to github (https://maven.pkg.github.com/antonovdmitriy/LearningAWSLambdas): transfer failed for https://maven.pkg.github.com/antonovdmitriy/LearningAWSLambdas/org/example/LearningAWSLambdas/1.0-SNAPSHOT/LearningAWSLambdas-1.0-20230313.140533-1.jar, status: 422 Unprocessable Entity -> [Help 1]
Error:  

**Solution** - use lower case to name of jar artifacts. 