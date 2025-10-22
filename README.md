# Test Task – Camera Parser

[🇺🇸 English](README.md) | [🇺🇦 Українська](README.ua.md)

## Task Overview

This is a simplified Spring Boot application that simulates working with data received from an external API.  
You are provided with a **skeleton project** that includes:

- A preconfigured mock server (returns a static JSON response).
- Empty service and DTO classes for implementation.

Your goal is to implement logic for parsing and validating **camera data**.

---

## Objective

You need to complete the implementation of the following components:

1. **`CameraService`** (in `com.example.test_task.service`):
   - Implement `getAllCameras()` to fetch data from the mocked API using `RequestsService`.
   - Implement `normalizeModel(String model)` to convert raw enum-like values (e.g. `SONY_ALPHA`) into camel-case format (e.g. `SonyAlpha`).

2. **`Camera` and `CamerasResponse` DTOs** (in `com.example.test_task.dto`):
   - Add appropriate fields and accessors based on the mock response.
   - `CamerasResponse` should contain a list of raw camera entries that need to be mapped to final `CameraDto` objects.

3. **Validation Rule**:
   - If any camera has no `channels`, it must not be included in the final list.

---

## Mock Response Example

The mock server is already configured and will return a String containing JSON like this:

```json
{
  "cameras": [
    { "name": "CAM-1", "type": "PoweredOffCamera", "channels": 2 },
    { "name": "Office", "type": "WorkingCamera", "channels": 3 },
    { "name": "CAM-34", "type": "Error"}
  ]
}
```

---

## Notes

- `MockServerConfig` is already set up and does not need to be changed.
- The application will automatically use the mock server at runtime.
- Make sure your test fails when invalid data is present.
