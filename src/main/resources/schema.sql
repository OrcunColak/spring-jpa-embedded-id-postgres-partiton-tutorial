-- See https://ishansoninitj.medium.com/postgres-partitioning-and-spring-data-jpa-d71a19331643
drop table security_prices_march_2024;
drop table security_prices_april_2024;
drop table security_prices_may_2024;
drop table security_prices;

create table security_prices (
 id varchar(255),
 security_id varchar(255),
 price numeric,
 business_date date,
 PRIMARY KEY (id, business_date)
) partition by range (business_date);

-- Create partitioned tables. In postgres, this has to be done manually :(
-- Range (Inclusive, Exclusive)
create table security_prices_march_2024 partition of security_prices for values from ('2024-03-01') to ('2024-04-01');
create table security_prices_april_2024 partition of security_prices for values from ('2024-04-01') to ('2024-05-01');
create table security_prices_may_2024 partition of security_prices for values from ('2024-05-01') to ('2024-06-01');
