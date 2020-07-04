package com.msc.parser;

import com.msc.handler.JoinRequestHandler;
import com.msc.handler.MsgResponseHandler;
import com.msc.handler.RegResponseHandler;
import com.msc.model.MessageConstants;

import java.util.StringTokenizer;

public class MessageParser {

    public MsgResponseHandler parse(String message) {
        message = message.substring(0, Integer.parseInt(message.substring(0, 4)));
        StringTokenizer stringTokenizer = new StringTokenizer(message, " ");
        int length = Integer.parseInt(stringTokenizer.nextToken());
        String response = stringTokenizer.nextToken();
        System.out.println(message);

        switch (response) {
            case MessageConstants.REGOK_MESSAGE:
                return new RegResponseHandler();
            case MessageConstants.JOIN_MESSAGE:
                return new JoinRequestHandler();
            case MessageConstants.SEARCH_MESSAGE:
                return new JoinRequestHandler();
        }
        return null;
    }
}
