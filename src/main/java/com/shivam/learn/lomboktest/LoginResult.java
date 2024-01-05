package com.shivam.learn.lomboktest;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.net.URL;
import java.time.Duration;
import java.time.Instant;

/**
 * @author sksingh created on 05/01/24
 */
@Getter
@Setter
@Accessors(fluent = true)
@RequiredArgsConstructor
public class LoginResult {

    private final @NonNull  Instant loginTs;
    private final @NonNull String authToken;
    private final @NonNull Duration tokenValidity;
    private final @NonNull URL tokenRefreshUrl;
    private String httpCode;

}
