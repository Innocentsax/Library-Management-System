package dev.Innocent.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LibraryStatus {

        ACTIVE("ACTIVE"),
        DELETE("DELETE"),
        INACTIVE("INACTIVE"),
        LOCKED("LOCKED");

        private final String LibraryStatus;

}
