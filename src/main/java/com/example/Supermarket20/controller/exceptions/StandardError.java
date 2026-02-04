package com.example.Supermarket20.controller.exceptions;

import java.time.Instant;

public record StandardError (Instant timestamp,
                             Integer status,
                             String error,
                             String message,
                             String path){
}
