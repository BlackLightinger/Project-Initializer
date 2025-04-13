# Получение токена oauth
## Вытаскивание данных по логину и паролю
### Resource owner password credentials flow
In this flow, a token is requested in exchange for the resource owner credentials (username and password).
The credentials should only be used when:
There is a high degree of trust between the resource owner and the client. For example, the client is part of the device operating system or a highly privileged application.
Other authorization grant types are not available (such as an authorization code).
Even though this grant type requires direct client access to the resource owner credentials, the resource owner credentials are used for a single request and are exchanged for an access token. This grant type can eliminate the need for the client to store the resource owner credentials for future use, by exchanging the credentials with a long-lived access token or refresh token.
To request an access token, you must make a POST request to /oauth/token with the following parameters:
```
{
  "grant_type"    : "password",
  "username"      : "user@example.com",
  "password"      : "secret"
}
```
Example cURL request:
```
echo 'grant_type=password&username=<your_username>&password=<your_password>' > auth.txt
curl --data "@auth.txt" --request POST "https://gitlab.example.com/oauth/token"
```
You can also use this grant flow with registered OAuth applications, by using HTTP Basic Authentication with the application’s client_id and client_secret:
```
echo 'grant_type=password&username=<your_username>&password=<your_password>' > auth.txt
curl --data "@auth.txt" --user client_id:client_secret \
     --request POST "https://gitlab.example.com/oauth/token"
```
Then, you receive a response containing the access token:
```
{
  "access_token": "1f0af717251950dbd4d73154fdf0a474a5c5119adad999683f5b450c460726aa",
  "token_type": "bearer",
  "expires_in": 7200
}
```
By default, the scope of the access token is api, which provides complete read/write access.
For testing, you can use the oauth2 Ruby gem:
```
client = OAuth2::Client.new('the_client_id', 'the_client_secret', :site => "https://example.com")
access_token = client.password.get_token('user@example.com', 'secret')
puts access_token.token
```
## Create a user-owned application

To create a new application for your user:
1. On the left sidebar, select your avatar.
2. Select __Edit profile__.
3. On the left sidebar, select __Applications__.
4. Enter a __Name__ and __Redirect URI__.
5. Select OAuth 2 __Scopes__ as defined in Authorized Applications.
6. In the __Redirect URI__, enter the URL where users are sent after they authorize with GitLab.
7. Select __Save application__. GitLab provides:
    - The OAuth 2 Client ID in the Application ID field.
    - The OAuth 2 Client Secret, accessible:
        - In the Secret field in GitLab 14.1 and earlier.
        - By selecting Copy in the Secret field in GitLab 14.2 and later.
    - The __Renew secret__ function in GitLab 15.9 and later. Use this function to generate and copy a new secret for this application. Renewing a secret prevents the existing application from functioning until the credentials are updated.

## Create a group-owned application

Introduced in GitLab 13.11.
To create a new application for a group:
1. Go to the desired group.
2. On the left sidebar, select __Settings > Applications__.
3. Enter a __Name__ and __Redirect URI__.
4. Select OAuth 2 scopes as defined in Authorized Applications.
5. In the __Redirect URI__, enter the URL where users are sent after they authorize with GitLab.
6. Select Save application. GitLab provides:
    - The OAuth 2 Client ID in the __Application ID__ field.
    - The OAuth 2 Client Secret, accessible:
        - In the __Secret__ field in GitLab 14.1 and earlier.
        - By selecting __Copy__ in the __Secret__ field in GitLab 14.2 and later.
    - The __Renew secret__ function in GitLab 15.9 and later. Use this function to generate and copy a new secret for this application. Renewing a secret prevents the existing application from functioning until the credentials are updated.

## Create an instance-wide application

To create an application for your GitLab instance:
1. On the left sidebar, expand the top-most chevron ().
2. Select __Admin Area__.
3. On the left sidebar, select __Applications__.
4. Select __New application__.
When creating application in the __Admin Area__ , mark it as __trusted__. The user authorization step is automatically skipped for this application.


## Personal/project/group access tokens

You can use access tokens to authenticate with the API by passing it in either the private_token parameter or the PRIVATE-TOKEN header.
Example of using the personal, project, or group access token in a parameter:
```
curl "https://gitlab.example.com/api/v4/projects?private_token=<your_access_token>"
```
Example of using the personal, project, or group access token in a header:
```
curl --header "PRIVATE-TOKEN: <your_access_token>" "https://gitlab.example.com/api/v4/projects"
```
You can also use personal, project, or group access tokens with OAuth-compliant headers:
```
curl --header "Authorization: Bearer <your_access_token>" "https://gitlab.example.com/api/v4/projects"
```

# Получение групп в проекте gitlab
| Attribute | Type | Required | Description |
| ----- | ------ | ------ | ------ |
| skip_groups | array of integers | no | Skip the group IDs passed |
| all_available | boolean | no | Show all the groups you have access to (defaults to false for authenticated users, true for administrators); Attributes owned and min_access_level have precedence |
| search |	string | no |	Return the list of authorized groups matching the search criteria|
| order_by|	string|	no|	Order groups by name, path, id, or similarity (if searching, introduced in GitLab 14.1). Default is name|
|sort|	string|	no|	Order groups in asc or desc order. Default is asc|
|statistics|	boolean|	no|	Include group statistics (administrators only). Note: The REST API response does not provide the full RootStorageStatistics data that is shown in the UI. To match the data in the UI, use GraphQL instead of REST. For more information, see the Group GraphQL reference.|
|with_custom_attributes|	boolean|	no|	Include custom attributes in response (administrators only)|
|owned|	boolean|	no|	Limit to groups explicitly owned by the current user|
|min_access_level|	integer|	no|	Limit to groups where current user has at least this role (access_level)|
|top_level_only|	boolean|	no|	Limit to top level groups, excluding all subgroups|

```
GET /groups
```
```
[
  {
    "id": 1,
    "name": "Foobar Group",
    "path": "foo-bar",
    "description": "An interesting group",
    "visibility": "public",
    "share_with_group_lock": false,
    "require_two_factor_authentication": false,
    "two_factor_grace_period": 48,
    "project_creation_level": "developer",
    "auto_devops_enabled": null,
    "subgroup_creation_level": "owner",
    "emails_disabled": null,
    "mentions_disabled": null,
    "lfs_enabled": true,
    "default_branch_protection": 2,
    "avatar_url": "http://localhost:3000/uploads/group/avatar/1/foo.jpg",
    "web_url": "http://localhost:3000/groups/foo-bar",
    "request_access_enabled": false,
    "full_name": "Foobar Group",
    "full_path": "foo-bar",
    "file_template_project_id": 1,
    "parent_id": null,
    "created_at": "2020-01-15T12:36:29.590Z",
    "ip_restriction_ranges": null
  }
]
```

When adding the parameter statistics=true and the authenticated user is an administrator, additional group statistics are returned.
```
GET /groups?statistics=true
```
```
[
  {
    "id": 1,
    "name": "Foobar Group",
    "path": "foo-bar",
    "description": "An interesting group",
    "visibility": "public",
    "share_with_group_lock": false,
    "require_two_factor_authentication": false,
    "two_factor_grace_period": 48,
    "project_creation_level": "developer",
    "auto_devops_enabled": null,
    "subgroup_creation_level": "owner",
    "emails_disabled": null,
    "mentions_disabled": null,
    "lfs_enabled": true,
    "default_branch_protection": 2,
    "avatar_url": "http://localhost:3000/uploads/group/avatar/1/foo.jpg",
    "web_url": "http://localhost:3000/groups/foo-bar",
    "request_access_enabled": false,
    "full_name": "Foobar Group",
    "full_path": "foo-bar",
    "file_template_project_id": 1,
    "parent_id": null,
    "created_at": "2020-01-15T12:36:29.590Z",
    "statistics": {
      "storage_size": 363,
      "repository_size": 33,
      "wiki_size": 100,
      "lfs_objects_size": 123,
      "job_artifacts_size": 57,
      "pipeline_artifacts_size": 0,
      "packages_size": 0,
      "snippets_size": 50,
      "uploads_size": 0
    },
    "wiki_access_level": "private"
  }
]
```

# Создание репозитория в группе

If your HTTP repository isn’t publicly accessible, add authentication information to the URL https://username:password@gitlab.company.com/group/project.git, where password is a public access key with the api scope enabled.
```
POST /projects
```
Example request:
```
curl --request POST --header "PRIVATE-TOKEN: <your-token>" \
     --header "Content-Type: application/json" --data '{
        "name": "new_project", "description": "New Project", "path": "new_project",
        "namespace_id": "42", "initialize_with_readme": "true"}' \
     --url 'https://gitlab.example.com/api/v4/projects/'
```
[Атрибуты и их описание](https://docs.gitlab.com/ee/api/projects.html#create-project)

# Добавление новой ветки в репозиторий и назначение ее default

Protects a single repository branch or several project repository branches using a wildcard protected branch.

```
POST /projects/:id/protected_branches
```
```
curl --request POST --header "PRIVATE-TOKEN: <your_access_token>" "https://gitlab.example.com/api/v4/projects/5/protected_branches?name=*-stable&push_access_level=30&merge_access_level=30&unprotect_access_level=40"
```
[Атрибуты и их описание](https://docs.gitlab.com/ee/api/protected_branches.html#protect-repository-branches)

# Push в gitlab

Allows you to create a single file. For creating multiple files with a single request, refer to the [commits API](https://docs.gitlab.com/ee/api/commits.html#create-a-commit-with-multiple-files-and-actions).
```
POST /projects/:id/repository/files/:file_path
```
|Attribute|Type|Required|Description|
|---------|----|--------|-----------|
|branch|	string|	yes|	Name of the new branch to create. The commit is added to this branch.|
|commit_message|	string|	yes|	The commit message.|
|content|	string|	yes|	The file’s content.|
|file_path|	string|	yes|	URL-encoded full path to new file. For example: lib%2Fclass%2Erb.|
|id|	integer or string|	yes|	The ID or URL-encoded path of the project owned by the authenticated user.|
|author_email|	string|	no|	The commit author’s email address.|
|author_name|	string|	no|	The commit author’s name.|
|encoding|	string|	no|	Change encoding to base64. Default is text.|
|execute_filemode|	boolean|	no|	Enables or disables the execute flag on the file. Can be true or false.|
|start_branch|	string|	no|	Name of the base branch to create the new branch from.|

```
curl --request POST --header 'PRIVATE-TOKEN: <your_access_token>' \
     --header "Content-Type: application/json" \
     --data '{"branch": "master", "author_email": "author@example.com", "author_name": "Firstname Lastname",
               "content": "some content", "commit_message": "create a new file"}' \
     "https://gitlab.example.com/api/v4/projects/13083/repository/files/app%2Fproject%2Erb"
```
Example response:
```
{
  "file_path": "app/project.rb",
  "branch": "master"
}
```