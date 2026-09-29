package api.tests;

import api.base.BaseApiTest;
import api.clients.CoinGeckoClient;
import api.dto.responses.BitCoinResponseDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Log;

import java.util.Map;

public class CoinGeckoAPITest extends BaseApiTest {

    private final CoinGeckoClient coinGeckoClient= new CoinGeckoClient();

    @Test(description = "Verify Bitcoin endpoint returns valid response")
    public void TC_01_verifyBitcoinResponseIsValid(){
        BitCoinResponseDTO bitCoinResponse = coinGeckoClient.getBitCoinDetails();

        BitCoinResponseDTO.MarketData marketData= bitCoinResponse.getMarketData();

        Assert.assertNotNull(marketData, "MarketData should not be null");

        Map<String, Double> prices= marketData.getCurrentPrice();
        Assert.assertNotNull(prices, "Current prices should not be null");

        Log.info("Verifying that response contains valid USD, GBP< EUR prices");
        Assert.assertTrue(prices.containsKey("usd"), "USD curreny key not found");
        Assert.assertTrue(prices.containsKey("gbp"), "GBP curreny key not found");
        Assert.assertTrue(prices.containsKey("eur"), "EUR curreny key not found");

        Assert.assertTrue(prices.get("usd")>=0, "Invalid value for USD");
        Assert.assertTrue(prices.get("gbp")>=0, "Invalid value for EUR");
        Assert.assertTrue(prices.get("eur")>=0, "Invalid value for GBP");


        Log.info("Verifying each cryptocurrency has a  market cap, and total volume");
        Map<String, Double> marketCaps= marketData.getMarketCap();
        Assert.assertNotNull(marketCaps, "Market Caps should not be null");

        Map<String, Double> totalVolume= marketData.getTotalVolume();
        Assert.assertNotNull(totalVolume, "Total Volume should not be null");

        Log.info("Verifying price percentage change exists");
        Assert.assertNotNull(marketData.getPriceChangePercentage24h(),"price change percentage in 24h should not be null");

        Log.info("Verifying home page url is not empty");
        Assert.assertFalse(bitCoinResponse.getLinks().getHomepage().get(0).isEmpty(),"Homepage url should not be empty");
    }

}
