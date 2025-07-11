package com.evry.analytics.DTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Setter
public class VisitorDTO {

    private OffsetDateTime createDate;

    private String uuid;

    private String userId;
}
