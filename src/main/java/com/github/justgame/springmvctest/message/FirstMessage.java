package com.github.justgame.springmvctest.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiecongle
 * @date 2021/2/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirstMessage extends BaseMessage {
    private String first;
}
