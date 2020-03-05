package io.bitbucket.team_21.app.data;

import io.bitbucket.team_21.app.data.model.LoggedInUser;

import java.io.IOException;

import javax.security.auth.login.LoginException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {
        try {
            // TODO: handle actual loggedInUser authentication
            if (username.equals("user@example.com") && password.equals("password")) {
                LoggedInUser fakeUser =
                        new LoggedInUser(
                                java.util.UUID.randomUUID().toString(),
                                "Example User");
                return new Result.Success<>(fakeUser);
            }
            else {
                return new Result.Error(new LoginException("Bad username/password"));
            }
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
