package com.shivam.learn.lomboktest;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.net.URL;
import java.time.Duration;
import java.time.Instant;

/**
 * @author sksingh created on 05/01/24
 */
@Getter
@Setter
public class LoginResult {

    private @NonNull Instant loginTs;
    private @NonNull String authToken;
    private @NonNull Duration tokenValidity;
    private @NonNull URL tokenRefreshUrl;
    private String httpCode;
}
