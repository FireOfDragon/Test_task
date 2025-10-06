# Test Task – Goose Parser

[🇺🇸 English](README.md) | [🇺🇦 Українська](README.uk.md)

## Task Overview

This is a simplified Spring Boot application that simulates working with data received from an external API.  
You are provided with a **skeleton project** that includes:

- Preconfigured mock server (returns a static JSON response).
- Empty service and DTO classes for implementation.

Your goal is to implement logic for parsing and validating geese data.

---

## Objective

You need to complete the implementation of the following components:

1. **`GeeseService`** (in `com.example.test_task.service`):
    - Implement `getAllGeese()` to fetch data from the mocked API using `RequestsService`.
    - Implement `normalizeType(String type)` to convert raw enum-like values (e.g. `WHITE_GOOSE`) into camel-case format (e.g. `WhiteGoose`).

2. **`Goose` and `GeeseResponse` DTOs** (in `com.example.test_task.dto`):
    - Add appropriate fields and accessors based on the mock response.
    - `GeeseResponse` should contain a list of raw goose entries that need to be mapped to final `Goose` objects.

3. **Validation Rule**:
    - If any goose has `age = 0`, it's entry must not be included in final List.

---

## Mock Response Example

The mock server is already configured and will return String that contains a JSON like this:

```json
{
  "geese": [
    { "name": "Sanya", "type": "AFRO_AMERICAN_GOOSE", "age": 2 },
    { "name": "Vanya", "type": "WHITE_GOOSE", "age": 3 },
    { "name": "Danya", "type": "LEGENDARY", "age": 0 }
  ]
}
```

---

## Notes

- `MockServerConfig` is already set up and does not need to be changed.
- The application will automatically use the mock server at runtime.
- Make sure your test fails when invalid data is present.

