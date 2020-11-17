
CREATE TABLE IF NOT EXISTS cities
(
    id            serial PRIMARY KEY,
    name          varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS weather_state
(
    id              serial PRIMARY KEY,
    city_id         int8,
    condition       integer ARRAY,
    request_time    date,
    temperature     float8,
    FOREIGN KEY (city_id) REFERENCES cities(id)
);

CREATE TABLE IF NOT EXISTS conditions_codes
(
    id         serial PRIMARY KEY,
    code       int8,
    value      text
);