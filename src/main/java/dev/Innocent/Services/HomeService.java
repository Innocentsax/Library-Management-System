package dev.Innocent.Services;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface HomeService {

    Map<String, Long> getTopTilesMap();
}
