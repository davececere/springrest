springrest
==========

To Use rest api with database:
1. create a database and run src/main/db/create.sql
2. edit RepositoryConfig.java with your connection settings for your database
3. build war and deploy
4. from the src/test/client directory execute curlCreate.sql to create a demo object. you may need to edit the context/host/port in the curl command for your deployment.
5. you can run src/test/client/curlGet.sh to fetch the new object by id

To try out an async request
1. hit the url <server>:<port>/<context>/async/webservicecall (this will make an async call to www.yahoo.com and render the result using servlet 3.0 asyc response)