---Table InAppPurchaseData---
CREATE TABLE `in_app_purchase_data` (
  `subscription_id` varchar(255) NOT NULL,
  `application_id` decimal(19,2) DEFAULT NULL,
  `application_id_string` varchar(255) DEFAULT NULL,
  `auto_renewing` bit(1) NOT NULL,
  `cancelled_sub_keep_days` int(11) NOT NULL,
  `confirmed` bit(1) NOT NULL,
  `country` varchar(255) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `days_lasted` int(11) NOT NULL,
  `expiration_date` bigint(20) NOT NULL,
  `expiration_intent` int(11) NOT NULL,
  `introductory_flag` bit(1) NOT NULL,
  `kind` int(11) NOT NULL,
  `last_order_id` varchar(255) DEFAULT NULL,
  `num_of_discount` int(11) NOT NULL,
  `num_of_periods` int(11) NOT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `ori_purchase_time` bigint(20) NOT NULL,
  `package_name` varchar(255) DEFAULT NULL,
  `pay_order_id` varchar(255) DEFAULT NULL,
  `pay_type` varchar(255) DEFAULT NULL,
  `price` bigint(20) NOT NULL,
  `product_group` varchar(255) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `purchase_state` bit(1) NOT NULL,
  `purchase_time` bigint(20) NOT NULL,
  `purchase_token` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `renew_price` bigint(20) NOT NULL,
  `renew_status` bit(1) NOT NULL,
  `retry_flag` bit(1) NOT NULL,
  `sdk_channel` varchar(255) DEFAULT NULL,
  `sub_isvalid` bit(1) NOT NULL,
  `trial_flag` bit(1) NOT NULL
) 



--
-- Table structure for table `subscription`
--

CREATE TABLE `subscription` (
  `sub_id` varchar(255) NOT NULL,
  `device_id` varchar(255) DEFAULT NULL,
  `end_date` bigint(20) NOT NULL,
  `freetrial` bit(1) NOT NULL,
  `introductory` bit(1) NOT NULL,
  `mode` varchar(255) DEFAULT NULL,
  `next_billing_date` bigint(20) NOT NULL,
  `original_transaction_id` varchar(255) DEFAULT NULL,
  `paid` bit(1) NOT NULL,
  `service_id` varchar(255) DEFAULT NULL,
  `sign_in` bit(1) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `transaction_id` varchar(255) DEFAULT NULL,
  `ubs_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `user_source` varchar(255) DEFAULT NULL
)




CREATE TABLE `sub_status_entity` (
  `sub_id` varchar(255) NOT NULL,
  `attempt_no` int(11) NOT NULL,
  `schedule_time` bigint(20) NOT NULL,
  `sub_status` varchar(255) DEFAULT NULL
)



CREATE TABLE `token_details` (
  `access_token_key` int(11) NOT NULL,
  `access_token` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `expire_at` datetime DEFAULT NULL,
  `expires_in` bigint(20) NOT NULL,
  `token_type` varchar(255) DEFAULT NULL
)


ALTER TABLE `in_app_purchase_data`
  ADD PRIMARY KEY (`subscription_id`);

--
-- Indexes for table `subscription`
--
ALTER TABLE `subscription`
  ADD PRIMARY KEY (`sub_id`);

--
-- Indexes for table `sub_status_entity`
--
ALTER TABLE `sub_status_entity`
  ADD PRIMARY KEY (`sub_id`);

--
-- Indexes for table `token_details`
--
ALTER TABLE `token_details`
  ADD PRIMARY KEY (`access_token_key`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `token_details`
--
ALTER TABLE `token_details`
  MODIFY `access_token_key` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;
