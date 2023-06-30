package readingSession;


    /*пример строчки спутника
    Время               Спутник               Азим. Выс. Зв.в Дист. С.ази С.выс
    2023-07-01 00:15:15 satellite 1-6         41.4 10.0    ?  1120 341.9  -9.4
    пробелы:
    после даты 1
    после времени 1
    после sate.. 1
    после номера 9
    после азимута 1
    после высоты 2-4 (проверить число или ?)
    после звюв
    --





    --



*/
public class SingleReadingSession {
    private String Time;
    private String Date;
    private String SatelliteName;
    private double Azimuth; //degrees
    private double Elevation; //degrees
    private String Mag; //for now it is useless; 1-10;
    private double Distance;
    private double SphericalAzimuth; //degrees
    private double SphericalElevation; //degrees


    private String input;
    public SingleReadingSession(String input){
        this.input = input;
        inputFiller(input);
    }

    private void inputFiller(String input){

        String[] beautifulArray = input.split("\\s+");

        this.Date = beautifulArray[0];
        this.Time = beautifulArray[1];
        this.SatelliteName = beautifulArray[2] + " " + beautifulArray[3];
        this.Azimuth = Double.parseDouble(beautifulArray[4]);
        this.Elevation = Double.parseDouble(beautifulArray[5]);
        this.Mag = beautifulArray[6];
        this.Distance = Double.parseDouble(beautifulArray[7]);
        this.SphericalAzimuth = Double.parseDouble(beautifulArray[8]);
        this.SphericalElevation = Double.parseDouble(beautifulArray[9]);
    }

    @Override
    public String toString(){
        return
                Date + " " + Time + " " +
                SatelliteName + "         " +
                Azimuth + " " + Elevation + "    "
                + Mag + " " +
                Distance + " " + SphericalAzimuth + " " + SphericalElevation;

    }

        public String getTime() {
            return Time;
        }

        public void setTime(String time) {
            Time = time;
        }

        public String getDate() {
            return Date;
        }

        public void setDate(String date) {
            Date = date;
        }

        public String getSatelliteName() {
            return SatelliteName;
        }

        public void setSatelliteName(String satelliteName) {
            SatelliteName = satelliteName;
        }

        public double getAzimuth() {
            return Azimuth;
        }

        public void setAzimuth(double azimuth) {
            Azimuth = azimuth;
        }

        public double getElevation() {
            return Elevation;
        }

        public void setElevation(double elevation) {
            Elevation = elevation;
        }

        public String getMag() {
            return Mag;
        }

        public void setMag(String mag) {
            Mag = mag;
        }

        public double getDistance() {
            return Distance;
        }

        public void setDistance(double distance) {
            Distance = distance;
        }

        public double getSphericalAzimuth() {
            return SphericalAzimuth;
        }

        public void setSphericalAzimuth(double sphericalAzimuth) {
            SphericalAzimuth = sphericalAzimuth;
        }

        public double getSphericalElevation() {
            return SphericalElevation;
        }

        public void setSphericalElevation(double sphericalElevation) {
            SphericalElevation = sphericalElevation;
        }
    }
