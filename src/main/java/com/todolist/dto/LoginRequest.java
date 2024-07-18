package com.todolist.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"username","password"})
public record LoginRequest(String username,String password) {

}
