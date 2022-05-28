CREATE TABLE app_users (

                      id BIGSERIAL PRIMARY KEY,

                      username VARCHAR(255) NOT NULL,

                      password VARCHAR(255) NOT NULL);

CREATE INDEX app_users_username_idx ON app_users (username);