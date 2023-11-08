package com.chandilove.appchl.infra.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serial;

@RequiredArgsConstructor
public class ImageSizeException extends Exception {
    @Serial
    private static final long serialVersionUID = -790789373814651162L;

    @Getter
    private final String fileName;
}
