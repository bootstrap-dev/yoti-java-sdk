package com.yoti.api.client;

import com.yoti.api.client.aml.AmlProfile;
import com.yoti.api.client.aml.AmlResult;

/**
 * <p>
 * Entry point to interact with the Yoti Connect API.
 * </p>
 * <p>
 * It can be safely cached and shared even by multiple threads.
 * </p>
 * a
 */
public interface YotiClient {

    /**
     * Get the activity details for a token. Amongst others contains the user profile with the user's attributes you
     * have selected in your application configuration on Yoti Portal.
     *
     * <b>Note: encrypted tokens should only be used once. You should not invoke this method multiple times with the same token.</b>
     *
     * @param encryptedYotiToken
     *            encrypted Yoti token (can be only decrypted with your application's private key). Note that this token must only be used once.
     * @return an {@link ActivityDetails} instance holding the user's attributes
     *
     * @throws ProfileException
     *             aggregate exception signalling issues during the call
     */
    ActivityDetails getActivityDetails(String encryptedYotiToken) throws ProfileException;

    /**
     * Request an AML check for the given profile.
     *
     * @param amlProfile
     *            Details of the profile to search for when performing the AML check
     * @return an {@link AmlProfile} with the results of the check
     *
     * @throws AmlException
     *             aggregate exception signalling issues during the call
     */
    AmlResult performAmlCheck(AmlProfile amlProfile) throws AmlException;

}
