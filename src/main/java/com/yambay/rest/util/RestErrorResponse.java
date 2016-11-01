package com.yambay.rest.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by chrisp on 5/10/16.
 */
public class RestErrorResponse {

        @Getter
        private String url;
        @Getter
        private String message;
        @Getter
        private String code;
        @Getter
        @Setter
        private List<String> parameters;

        public RestErrorResponse(String url, String message) {
            super();
            this.url = url;
            this.message = message;
        }

        public RestErrorResponse(String url, String message, String code, List<String> parameters) {
            super();
            this.url = url;
            this.message = message;
            this.code = code;
            this.parameters = parameters;
        }


}
