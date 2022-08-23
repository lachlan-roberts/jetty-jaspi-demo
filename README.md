## JASPI Demo with Jetty

This project builds a custom JASPIC Authenticaton module and registers it with the Jetty default `AuthConfigFactory` through `jaspi-authmoduleconfig.xml`.

This authentication module is extremely basic and just authenticates all users with `testUserPrincipal`.

The `custom-jaspi-auth-module.jar` file is copied to `jetty-base/lib/ext` and is added to the server classpath because the Jetty `ext` module is enabled.

The `jetty-base/etc/jaspi/jaspi-authmoduleconfig.xml` file is then used to register the `TestAuthConfigProvider` and `TestServerAuthModule` with the static setter on `AuthConfigFactory`.

To build and run this project you just need to do:
```
mvn jetty:run
```
And access http://localhost:8080 in the browser.