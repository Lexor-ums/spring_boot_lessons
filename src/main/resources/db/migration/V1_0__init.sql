
CREATE TABLE IF NOT EXISTS cities
(
    id            BIGSERIAL PRIMARY KEY,
    name          varchar(255) NOT NULL unique
);

CREATE TABLE IF NOT EXISTS weather_state
(
    id              BIGSERIAL PRIMARY KEY,
    city_id         bigint,
    condition       integer ARRAY,
    request_time    date,
    temperature     float8,
    FOREIGN KEY (city_id) REFERENCES cities(id)
);

CREATE TABLE IF NOT EXISTS conditions_codes
(
    id         BIGSERIAL PRIMARY KEY,
    code       int4,
    value      text
);