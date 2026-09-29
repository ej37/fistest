package api.dto.responses;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitCoinResponseDTO {

    private String id;
    private String symbol;
    private String name;

    @JsonProperty("market_data")
    private MarketData marketData;

    private Links links;


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MarketData{

        @JsonProperty("current_price")
        private Map<String, Double> currentPrice;

        @JsonProperty("market_cap")
        private Map<String, Double> marketCap;

        @JsonProperty("total_volume")
        private Map<String, Double> totalVolume;

        @JsonProperty("price_change_percentage_24h")
        private double priceChangePercentage24h;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Links{
        private List<String> homepage;
    }
}
