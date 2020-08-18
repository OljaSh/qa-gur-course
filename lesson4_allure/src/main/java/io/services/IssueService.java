package io.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@Accessors(fluent=true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueService implements Serializable {
  // protected
}
