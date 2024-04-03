package GiftCerificatePayment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.PaymentPage;
import tasks.PaymentPageTasks;

public class GiftCertificateForGc extends baseClass {

    // Initialize PaymentPage instance
    private static final PaymentPage paymentPage = new PaymentPage(driver);

    // Method to redeem gift codes for Gift Certificates
    public static void giftCodeForGc() throws Exception {
        // Scroll the window by 500 pixels
        Actionsss.scrollWindowsByPixel(500);

        // Check if the Gift Certificate label is present
        if (Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
            // Provided data: Gift Certificate codes
            String[] data = TestData.GiftCerificateCodeforGc;

            // Iterate over the array and redeem each Gift Certificate
            for (String gcCodes : data) {
            	           	
                // Count the number of elements in the array
                int arrayLength = data.length;
                logger.info("Number of Gift Certificates: " + arrayLength);

                // Click on the Gift Certificate input field
                Actionsss.javascriptClick(paymentPage.getGiftcertificateInput());
                logger.info("Gift Certificate Code: " + gcCodes);
                // Enter the Gift Certificate code in the input field
                Actionsss.sendKeys(paymentPage.getGiftcertificateInput(), gcCodes, gcCodes + " gift code");
                Thread.sleep(1000);

                // Click on the Apply Gift Card button
                Actionsss.javascriptClick(paymentPage.getApplyGiftCardButton());
                logger.info("Apply button is selected");

                // Wait for 2 seconds
                Thread.sleep(2000);

                // Handle different scenarios based on the presence of error messages
                if (Actionsss.elementSize(paymentPage.getInsufficientGiftCodeBalError())) {
                    logger.info("Insufficient funds in this " + gcCodes + " gift card");
                    Actionsss.clearText(paymentPage.getGiftcertificateInput());
                } else if (Actionsss.elementSize(paymentPage.getGcBelongsToDifferentCustomerError())) {
                    logger.info("This " + gcCodes + " Gift Card belongs to a different customer");
                    Actionsss.clearText(paymentPage.getGiftcertificateInput());
                } else if (Actionsss.elementSize(paymentPage.getInvalidGcError())) {
                    logger.info("This " + gcCodes + " is an invalid gift code");
                    Actionsss.clearText(paymentPage.getGiftcertificateInput());
                } else if (Actionsss.elementSize(paymentPage.getRedemptionWithGcMsg())) {
                    // If redemption with Gift Certificate is successful
                    logger.info("Your order has been paid using gift certificates message is displayed.");
                    String gcRedeemedMsg = Actionsss.getTextOfElement(paymentPage.getsuccessGiftCodeRedemptionMsg());

                    // Define a regular expression pattern to match uppercase letters
                    Pattern pattern = Pattern.compile("[A-Z]+");
                    // Create a matcher with the input text
                    Matcher matcher = pattern.matcher(gcRedeemedMsg);
                    // Find the first match
                    if (matcher.find()) {
                        // Extract the matched uppercase letters
                        String uppercaseLetters = matcher.group();
                        // Log the uppercase letters
                        logger.info("Uppercase letters: " + uppercaseLetters);
                        gcCodeRedeemed = uppercaseLetters;
                    }

                    logger.info("Gift Code Redeemed: " + gcCodeRedeemed);

                    // Click on the Review Order button
                    PaymentPageTasks.clickReviewOrderButton();
                    // Exit the loop
                    break;
                }

                // Check if it's the last iteration
                if (gcCodes.equals(data[data.length - 1])) {
                    logger.info("Last iteration completed");
                    test.info("No balance in Gift certificates, so payment is being done with a credit card");
                    PaymentPageTasks.creditCardWithValidDetails();
                }
            }
        } else {
            // If the Gift certificate is in the cart
            test.info("Gift certificate is in cart");
            test.pass("No element to redeem the Gift code");
        }
    }

    // Method to get the success message after redeeming Gift Certificates
    public static void getSuccessMsg() throws InterruptedException {
        float extractedAmount = 0;
        if (Actionsss.elementSize(paymentPage.getsuccessGiftCodeRedemptionMsgList())) {
            // Retrieve the success message containing the redeemed gift code and amount
            String gcRedeemedMsg = Actionsss.getTextOfElement(paymentPage.getsuccessGiftCodeRedemptionMsg());

            // Extract the last four digits of the redeemed gift code
            String lastFourDigits = gcRedeemedMsg.substring(gcRedeemedMsg.length() - 4);
            gcCodeRedeemed = lastFourDigits;

            // Define a regular expression pattern to match the amount pattern
            Pattern amountPattern = Pattern.compile("\\$([0-9]+\\.[0-9]{2})");
            // Create a matcher object to find the amount pattern in the message
            Matcher matcher = amountPattern.matcher(gcRedeemedMsg);

            // Check if the pattern is found in the message
            if (matcher.find()) {
                // Extract the matched amount
                String extractedAmountStr = matcher.group(1);
                extractedAmount = Float.parseFloat(extractedAmountStr);
                logger.info("Extracted Amount: " + extractedAmount);

                // Add the extracted amount to the total detached amount
                totalGcDetechedAmount = totalGcDetechedAmount + extractedAmount;
                logger.info("Total Gift Certificate Detached Amount: " + totalGcDetechedAmount);

                // Retrieve the detected amount of Gift Certificates
                String gcAmountDetechedStr = Actionsss.getTextOfElement(paymentPage.getGiftCertificateBalDetected());

                // Remove "-" and "$" symbols from the detected amount
                String result = gcAmountDetechedStr.replace("-", "").replace("$", "");
                logger.info("Result: " + result);

                // Convert the result to float for comparison
                float expectedAmountDetected = Float.parseFloat(result);

                // Compare the total detached amount with the expected amount detected
                if (totalGcDetechedAmount == expectedAmountDetected) {
                    logger.info("Gift Certificate redeemed successfully. Redeemed Amount: " + totalGcDetechedAmount
                            + ", Total Amount: " + Actionsss.getTextOfElement(paymentPage.getTotalPriceInPaymentPage())
                            + ", Detected Amount: " + expectedAmountDetected);
                    test.pass("Gift Certificate redeemed successfully. Redeemed Amount: " + totalGcDetechedAmount
                            + ", Total Amount: " + Actionsss.getTextOfElement(paymentPage.getTotalPriceInPaymentPage())
                            + ", Detected Amount: " + expectedAmountDetected);
                } else {
                    logger.info("Gift Certificate not redeemed. Redeemed Amount: " + totalGcDetechedAmount
                            + ", Total Amount: " + Actionsss.getTextOfElement(paymentPage.getTotalPriceInPaymentPage())
                            + ", Detected Amount: " + expectedAmountDetected);
                    test.fail("Gift Certificate not redeemed. Redeemed Amount: " + totalGcDetechedAmount
                            + ", Total Amount: " + Actionsss.getTextOfElement(paymentPage.getTotalPriceInPaymentPage())
                            + ", Detected Amount: " + expectedAmountDetected);
                }
            } else {
                logger.error("No amount found in the input string.");
            }
        }
    }
}
