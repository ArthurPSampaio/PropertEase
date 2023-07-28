package br.com.ByteNest.PropertEase.models.schedules;

import br.com.ByteNest.PropertEase.models.clients.Client;
import br.com.ByteNest.PropertEase.models.realty.Realty;

import java.util.Date;

public record RegisterSchedulesData(
        Client clientId,
        Realty realtyId,
        Date scheduled
) {
}
