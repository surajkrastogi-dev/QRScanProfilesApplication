package com.example.QRProfilesApplication.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TokenSettings {

	@Value("${app.token.expiry-minutes:10}")
    private int expiryMinutes;

    @Value("${app.token.one-time:true}")
    private boolean oneTime;

    public int getExpiryMinutes() {
        return expiryMinutes;
    }

    public boolean isOneTime() {
        return oneTime;
    }
}
