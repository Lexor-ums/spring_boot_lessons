Create table weather_state_conditions
(
    id BIGSERIAL PRIMARY KEY,
    weather_state_id integer,
    condition integer,
    FOREIGN KEY (weather_state_id) REFERENCES weather_state(id)
);

CREATE VIEW weather_view
AS SELECT
       id,
       condition
   FROM
       weather_state v;
SELECT * from weather_view;
create or replace function f() RETURNS void
as $$
DECLARE
    rec record;
    var int;
BEGIN
    FOR rec IN (SELECT * FROM weather_view) LOOP
            FOREACH var SLICE 1 IN ARRAY rec.condition LOOP
                    INSERT INTO weather_state_conditions (weather_state_id, condition) VALUES(rec.id, var);
                END LOOP;
        END LOOP;
END;
$$ language plpgsql;
SELECT "f"();
ALTER TABLE weather_state DROP  COLUMN condition CASCADE;