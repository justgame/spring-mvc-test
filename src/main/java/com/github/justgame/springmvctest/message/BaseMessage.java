package com.github.justgame.springmvctest.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xiecongle
 * @date 2021/2/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseMessage {
    private Long messageId;

    private Date timestamp;
}
