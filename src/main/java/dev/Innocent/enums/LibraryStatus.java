package dev.Innocent.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LibraryStatus {

        ACTIVE("ACTIVE"),
        INACTIVE("INACTIVE"),
        LOCKED("LOCKED");

        private final String LibraryStatus;

}
