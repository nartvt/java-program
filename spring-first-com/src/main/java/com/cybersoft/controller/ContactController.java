package com.cybersoft.controller;

import com.cybersoft.service.EmailService;
import com.cybersoft.service.MessageService;

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
