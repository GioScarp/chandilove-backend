package com.chandilove.appchl.infra.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.util.Set;

@RequiredArgsConstructor
public class ObjectValidationException extends Exception {

    @Serial
    private static final long serialVersionUID = -7908494373814651162L;

    @Getter
    private final Set<String> violations;

    @Getter
    private final String violationSource;

}
