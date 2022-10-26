SELECT DISTINCT Country.Name
FROM City
JOIN Country ON City.CountryId = Country.CountryId
WHERE Population > 400;

SELECT Country.Name
FROM Country
WHERE CountryID NOT IN (SELECT cn.CountryID
                        FROM building
                        JOIN city c on c.CityID = building.CityID
                        JOIN country cn on c.CityID = cn.CountryID);
