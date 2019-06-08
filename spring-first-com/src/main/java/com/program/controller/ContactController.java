package com.program.controller;

import com.program.service.EmailService;
import com.program.service.MessageService;

public class ContactController {
  private MessageService _service = null;

  public ContactController() {

  }

  public void setService(MessageService service) {
    this._service = service;
  }

  public void sendMessage() {
    _service.sendMessage();
  }
}
