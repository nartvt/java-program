package com.cybersoft.controller;

import com.cybersoft.service.MessageService;

public class HomeController {
  private MessageService _service = null;

  public HomeController(MessageService service) {
    this._service = service;
  }

  public void set_service(MessageService _service) {
    this._service = _service;
  }

  public void sendMessage() {
    _service.sendMessage();
  }

}
