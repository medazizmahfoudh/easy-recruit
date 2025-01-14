package com.easyrecruit.core.ws.rest.model.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class AppUser {
  private Long id;
  private String uuid;

  private String username;

  private String email;

  private String password;

  private boolean enabled;

  @Enumerated(EnumType.STRING)
  private AppUserRole role;

}
