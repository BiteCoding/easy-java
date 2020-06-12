import basis.Bild;
import basis.Farbe;
import basis.Fenster;
import basis.Hilfe;
import basis.Maus;
import basis.Tastatur;

public class MAINnormal {
    private Fenster fenster = new Fenster(1920, 1080);
    private rocket Rocket;
    private Bild star;
    private Bild ScoreStar1;
    private Bild ScoreStar2;
    private Bild ScoreStar3;
    private Bild ScoreStar4;
    private Bild ScoreStar5;
    private Bild ScoreStar6;
    private Bild ScoreStar7;
    private Bild ScoreStar8;
    private Bild ScoreStar9;
    private Bild ScoreStar10;
    private Bild Deathstar;
    private Bild BadStar3;
    private Bild BadStar6;
    private Bild BadStar9;
    private Bild PreStar1;
    private Bild PreStar2;
    private Bild PreStar3;
    private Bild PreStar4;
    private Bild PreStar5;
    private Bild PreStar6;
    private Bild PreStar7;
    private Bild PreStar8;
    private Bild PreStar9;
    private Bild PreStar10;
    private Bild rocket;
    private Bild rocketLinks;
    private Bild rocketRunter;
    private Bild rocketHoch;
    private Bild laserbeam;
    private Bild laserbeamup;
    private Bild Meteorite;
    private Stern stern;
    private stift stift;
    private Tastatur keyboard;
    private Maus maus;
    private Meteorite stein;
    boolean exit;
    boolean RESTART;
    boolean hit;
    boolean SchussRechts;
    boolean SchussLinks;
    boolean SchussOben;
    boolean SchussUnten;
    double speed;
    double firespeedRechts;
    double firespeedLinks;
    double firespeedOben;
    double firespeedUnten;
    int pause;
    int x;
    int y;
    int g;
    int l;
    int k;
    int p;
    int m;
    double i;
    double d;
    double e;
    double f;
    double h;
    String LocationRakete1 = "res/rocket1.png";
    String LocationRakete2 = "res/rocket2.png";
    String LocationRakete3 = "res/rocket3.png";
    String LocationStern = "res/stern.png";
    String LocationDeathStar = "res/stern.png";
    String LocationPreStar = "res/sternvorlage.png";
    String BadStar = "res/Badstern.png";
    String LocationBackground = "res/galaxy.jpg";
    String wasted = "res/Red-Rope-You-Died.jpg";
    String laser = "res/LASERBEAM.png";
    String meteorite = "res/meteorite-cartoon-icon-white-background-79741243.png";

    public MAINnormal() {
        this.fenster.setzeTitel("Rocket");
        this.keyboard = new Tastatur();
        this.maus = new Maus();
    }

    private void ScoreStar() {
        int i = (int)this.stift.getScore();
        this.PreStar1.setzePosition((double)this.x, (double)this.y);
        this.PreStar2.setzePosition((double)(this.x + 50), (double)this.y);
        this.PreStar3.setzePosition((double)(this.x + 100), (double)this.y);
        this.PreStar4.setzePosition((double)(this.x + 150), (double)this.y);
        this.PreStar5.setzePosition((double)(this.x + 200), (double)this.y);
        this.PreStar6.setzePosition((double)(this.x + 250), (double)this.y);
        this.PreStar7.setzePosition((double)(this.x + 300), (double)this.y);
        this.PreStar8.setzePosition((double)(this.x + 350), (double)this.y);
        this.PreStar9.setzePosition((double)(this.x + 400), (double)this.y);
        this.PreStar10.setzePosition((double)(this.x + 450), (double)this.y);
        this.x = this.fenster.breite() / 2 - 300;
        this.y = this.fenster.hoehe() - 60;
        switch(i) {
            case 1:
                this.PreStar1.setzeSichtbar(false);
                this.ScoreStar1.setzeSichtbar(true);
                this.ScoreStar1.setzeGroesse(40.0D, 40.0D);
                this.ScoreStar1.setzePosition((double)this.x, (double)this.y);
                break;
            case 2:
                this.PreStar2.setzeSichtbar(false);
                this.ScoreStar2.setzeSichtbar(true);
                this.ScoreStar2.setzeGroesse(40.0D, 40.0D);
                this.ScoreStar2.setzePosition((double)(this.x + 50), (double)this.y);
                break;
            case 3:
                this.PreStar3.setzeSichtbar(false);
                this.ScoreStar3.setzeSichtbar(true);
                this.ScoreStar3.setzeGroesse(40.0D, 40.0D);
                this.ScoreStar3.setzePosition((double)(this.x + 100), (double)this.y);
                break;
            case 4:
                this.PreStar4.setzeSichtbar(false);
                this.ScoreStar4.setzeSichtbar(true);
                this.ScoreStar4.setzeGroesse(40.0D, 40.0D);
                this.ScoreStar4.setzePosition((double)(this.x + 150), (double)this.y);
                break;
            case 5:
                this.PreStar5.setzeSichtbar(false);
                this.ScoreStar5.setzeSichtbar(true);
                this.ScoreStar5.setzeGroesse(40.0D, 40.0D);
                this.ScoreStar5.setzePosition((double)(this.x + 200), (double)this.y);
                break;
            case 6:
                this.PreStar6.setzeSichtbar(false);
                this.ScoreStar6.setzeSichtbar(true);
                this.ScoreStar6.setzeGroesse(40.0D, 40.0D);
                this.ScoreStar6.setzePosition((double)(this.x + 250), (double)this.y);
                break;
            case 7:
                this.PreStar7.setzeSichtbar(false);
                this.ScoreStar7.setzeSichtbar(true);
                this.ScoreStar7.setzeGroesse(40.0D, 40.0D);
                this.ScoreStar7.setzePosition((double)(this.x + 300), (double)this.y);
                break;
            case 8:
                this.PreStar8.setzeSichtbar(false);
                this.ScoreStar8.setzeSichtbar(true);
                this.ScoreStar8.setzeGroesse(40.0D, 40.0D);
                this.ScoreStar8.setzePosition((double)(this.x + 350), (double)this.y);
                break;
            case 9:
                this.PreStar9.setzeSichtbar(false);
                this.ScoreStar9.setzeSichtbar(true);
                this.ScoreStar9.setzeGroesse(40.0D, 40.0D);
                this.ScoreStar9.setzePosition((double)(this.x + 400), (double)this.y);
                break;
            case 10:
                this.PreStar10.setzeSichtbar(false);
                this.ScoreStar10.setzeSichtbar(true);
                this.ScoreStar10.setzeGroesse(40.0D, 40.0D);
                this.ScoreStar10.setzePosition((double)(this.x + 450), (double)this.y);
        }

    }

    private void RocketChange() {
        if (this.stift.getScore() == 5.0D && this.g == 0) {
            Hilfe.warte(500L);
            this.rocket.setzeSichtbar(false);
            this.rocketLinks.setzeSichtbar(false);
            this.rocketHoch.setzeSichtbar(false);
            this.rocketRunter.setzeSichtbar(false);
            this.rocket = new Bild(this.LocationRakete2);
            this.rocket.setzeGroesse(200.0D, 100.0D);
            this.rocketLinks = new Bild(this.LocationRakete2);
            this.rocket.dreheUmOhneGroessenAnpassung(180.0D);
            this.rocketLinks.setzeGroesse(200.0D, 100.0D);
            this.rocketHoch = new Bild(this.LocationRakete3);
            this.rocketHoch.setzeGroesse(100.0D, 200.0D);
            this.rocketRunter = new Bild(this.LocationRakete3);
            this.rocketRunter.dreheUmMitGroessenAnpassung(180.0D);
            this.rocketRunter.setzeGroesse(100.0D, 200.0D);
            this.rocketLinks.setzeSichtbar(false);
            this.rocketRunter.setzeSichtbar(false);
            this.rocketHoch.setzeSichtbar(false);
            ++this.g;
        }

    }

    private void DeathStar3() {
        if (this.stift.getScore() == 3.0D && this.l == 0 && !this.Meteorite.istSichtbar()) {
            this.Deathstar.setzeSichtbar(true);
            this.Deathstar.setzeGroesse(this.stern.getSize(), this.stern.getSize());
            this.Deathstar.setzePosition((double)Hilfe.zufall(100, Hilfe.zufall(1920 - 100, this.stern.getY() - 5)), (double)Hilfe.zufall(100, Hilfe.monitorHoehe() - 100));
            ++this.l;
        }

    }

    private void DeathStar6() {
        if (this.stift.getScore() == 6.0D && this.k == 0 && !this.Meteorite.istSichtbar()) {
            this.Deathstar.setzeSichtbar(true);
            this.Deathstar.setzeGroesse(this.stern.getSize(), this.stern.getSize());
            this.Deathstar.setzePosition((double)Hilfe.zufall(100, Hilfe.zufall(1920 - 100, this.stern.getY() - 5)), (double)Hilfe.zufall(100, Hilfe.monitorHoehe() - 100));
            ++this.k;
        }

    }

    private void DeathStar9() {
        if (this.stift.getScore() == 9.0D && this.p == 0 && !this.Meteorite.istSichtbar()) {
            this.Deathstar.setzeSichtbar(true);
            this.Deathstar.setzeGroesse(this.stern.getSize(), this.stern.getSize());
            this.Deathstar.setzePosition((double)Hilfe.zufall(100, Hilfe.zufall(1920 - 100, this.stern.getY() - 5)), (double)Hilfe.zufall(100, Hilfe.monitorHoehe() - 100));
            ++this.p;
        }

    }

    private void OldRocketDimensions() {
        if (this.stift.getScore() < 5.0D) {
            this.rocket.setzeGroesse(200.0D * this.Rocket.getStreckung(), 200.0D * this.Rocket.getStreckung());
            this.rocketLinks.setzeGroesse(200.0D * this.Rocket.getStreckung(), 200.0D * this.Rocket.getStreckung());
            this.rocketRunter.setzeGroesse(200.0D * this.Rocket.getStreckung(), 200.0D * this.Rocket.getStreckung());
            this.rocketHoch.setzeGroesse(200.0D * this.Rocket.getStreckung(), 200.0D * this.Rocket.getStreckung());
        }

    }

    private void PositionRocket() {
        this.rocket.setzePosition(this.Rocket.getxPos() - 129.0D * this.Rocket.getStreckung(), this.Rocket.getyPos() - 98.0D * this.Rocket.getStreckung());
        this.rocketLinks.setzePosition(this.Rocket.getxPos() - 129.0D * this.Rocket.getStreckung(), this.Rocket.getyPos() - 98.0D * this.Rocket.getStreckung());
        this.rocketRunter.setzePosition(this.Rocket.getxPos() - 129.0D * this.Rocket.getStreckung(), this.Rocket.getyPos() - 98.0D * this.Rocket.getStreckung());
        this.rocketHoch.setzePosition(this.Rocket.getxPos() - 129.0D * this.Rocket.getStreckung(), this.Rocket.getyPos() - 98.0D * this.Rocket.getStreckung());
    }

    private void KollisionGut() {
        if ((this.laserbeam.kollisionErkanntMit(this.Meteorite) || this.laserbeamup.kollisionErkanntMit(this.Meteorite)) && (this.laserbeam.istSichtbar() || this.laserbeamup.istSichtbar())) {
            this.laserbeam.setzeSichtbar(false);
            this.laserbeamup.setzeSichtbar(false);
            this.hit = true;
            this.Meteorite.setzeSichtbar(false);
            this.star.setzeSichtbar(true);
        }

        if (this.hit) {
            if (this.stift.getScore() == 3.0D) {
                this.DeathStar3();
            }

            if (this.stift.getScore() == 6.0D) {
                this.DeathStar6();
            }

            if (this.stift.getScore() == 9.0D) {
                this.DeathStar9();
            }

            if ((this.rocket.kollisionErkanntMit(this.star) || this.laserbeam.kollisionErkanntMit(this.star) || this.laserbeamup.kollisionErkanntMit(this.star)) && !this.Meteorite.istSichtbar()) {
                this.stein.pickLocation();
                this.stern.pickLocation();
                this.stern.size();
                this.stift.setScore(this.stift.getScore() + 1.0D);
                this.hit = false;
                this.Meteorite.setzeSichtbar(true);
                this.star.setzeSichtbar(false);
            }
        }

    }

    private void KollisionSchlecht() {
        if ((this.hit = true) && (this.stift.getScore() == 3.0D || this.stift.getScore() == 6.0D || this.stift.getScore() == 9.0D) && !this.Meteorite.istSichtbar() && (this.rocket.kollisionErkanntMit(this.Deathstar) || this.laserbeam.kollisionErkanntMit(this.Deathstar) || this.laserbeamup.kollisionErkanntMit(this.Deathstar))) {
            this.Erase();
            this.ScoreStar10.setzeSichtbar(false);
            switch((int)this.stift.getScore()) {
                case 3:
                    this.PreStar4.setzeSichtbar(false);
                    this.BadStar3.setzeSichtbar(true);
                    this.BadStar3.setzeGroesse(40.0D, 40.0D);
                    this.BadStar3.setzePosition((double)(this.x + 150), (double)this.y);
                    break;
                case 6:
                    this.PreStar7.setzeSichtbar(false);
                    this.BadStar6.setzeSichtbar(true);
                    this.BadStar6.setzeGroesse(40.0D, 40.0D);
                    this.BadStar6.setzePosition((double)(this.x + 300), (double)this.y);
                    break;
                case 9:
                    this.PreStar10.setzeSichtbar(false);
                    this.BadStar9.setzeSichtbar(true);
                    this.BadStar9.setzeGroesse(40.0D, 40.0D);
                    this.BadStar9.setzePosition((double)(this.x + 450), (double)this.y);
            }

            while(!this.keyboard.istGedrueckt('\n')) {
                if (this.m == 0) {
                    this.fenster.ladeBildInZeichenflaeche(this.wasted);
                    ++this.m;
                }

                this.stift.lose();
                if (this.keyboard.istGedrueckt('\u001b')) {
                    System.exit(0);
                }
            }

            this.fenster.setzeSichtbar(false);
            MAINnormal Rocket = new MAINnormal();
            Rocket.fuehreAus();
        }

    }

    private void Movement() {
        if (this.keyboard.istGedrueckt('w')) {
            this.Rocket.setyPos(this.Rocket.getyPos() - this.speed);
            this.rocketRunter.setzeSichtbar(false);
            this.rocket.setzeSichtbar(false);
            this.rocketLinks.setzeSichtbar(false);
            this.rocketHoch.setzeSichtbar(true);
        } else if (this.keyboard.istGedrueckt('s')) {
            this.Rocket.setyPos(this.Rocket.getyPos() + this.speed);
            this.rocketRunter.setzeSichtbar(true);
            this.rocketLinks.setzeSichtbar(false);
            this.rocket.setzeSichtbar(false);
            this.rocketHoch.setzeSichtbar(false);
        } else if (this.keyboard.istGedrueckt('a')) {
            this.rocket.setzeSichtbar(false);
            this.rocketRunter.setzeSichtbar(false);
            this.rocketLinks.setzeSichtbar(true);
            this.rocketHoch.setzeSichtbar(false);
            this.Rocket.setxPos(this.Rocket.getxPos() - this.speed);
        } else if (this.keyboard.istGedrueckt('d')) {
            this.rocket.setzeSichtbar(true);
            this.rocketLinks.setzeSichtbar(false);
            this.rocketRunter.setzeSichtbar(false);
            this.rocketHoch.setzeSichtbar(false);
            this.Rocket.setxPos(this.Rocket.getxPos() + this.speed);
        }

    }

    private void Fenstersmoothness() {
        if (this.Rocket.getyPos() < 0.0D) {
            this.Rocket.setyPos((double)Hilfe.monitorHoehe());
        }

        if (this.Rocket.getyPos() > (double)Hilfe.monitorHoehe()) {
            this.Rocket.setyPos(0.0D);
        }

        if (this.Rocket.getxPos() > (double)1920) {
            this.Rocket.setxPos(0.0D);
        }

        if (this.Rocket.getxPos() < 0.0D) {
            this.Rocket.setxPos((double)1920);
        }

    }

    private void Erase() {
        this.rocket.setzeSichtbar(false);
        this.rocketLinks.setzeSichtbar(false);
        this.rocketRunter.setzeSichtbar(false);
        this.star.setzeSichtbar(false);
        this.Deathstar.setzeSichtbar(false);
        this.rocketHoch.setzeSichtbar(false);
        this.fenster.setzeHintergrundFarbe(Farbe.SCHWARZ);
        this.PreStar10.setzeSichtbar(false);
        this.ScoreStar10.setzeSichtbar(true);
        this.ScoreStar10.setzeGroesse(40.0D, 40.0D);
        this.ScoreStar10.setzePosition((double)(this.x + 450), (double)this.y);
        this.laserbeam.setzeSichtbar(false);
        this.laserbeamup.setzeSichtbar(false);
        this.Meteorite.setzeSichtbar(false);
    }

    private void setFireSpeed() {
        if (this.stift.getScore() < 5.0D) {
            if (this.rocket.istSichtbar()) {
                if (this.Rocket.getxPos() < 1920.0D && this.Rocket.getxPos() > 1680.0D) {
                    this.firespeedRechts = 1.0D;
                }

                if (this.Rocket.getxPos() < 1680.0D && this.Rocket.getxPos() > 1440.0D) {
                    this.firespeedRechts = 2.0D;
                }

                if (this.Rocket.getxPos() < 1440.0D && this.Rocket.getxPos() > 1200.0D) {
                    this.firespeedRechts = 3.0D;
                }

                if (this.Rocket.getxPos() < 1200.0D && this.Rocket.getxPos() > 960.0D) {
                    this.firespeedRechts = 4.0D;
                }

                if (this.Rocket.getxPos() < 960.0D && this.Rocket.getxPos() > 720.0D) {
                    this.firespeedRechts = 5.0D;
                }

                if (this.Rocket.getxPos() < 720.0D && this.Rocket.getxPos() > 480.0D) {
                    this.firespeedRechts = 6.0D;
                }

                if (this.Rocket.getxPos() < 480.0D && this.Rocket.getxPos() > 240.0D) {
                    this.firespeedRechts = 7.0D;
                }

                if (this.Rocket.getxPos() < 240.0D && this.Rocket.getxPos() > 0.0D) {
                    this.firespeedRechts = 8.0D;
                }
            }

            if (this.rocketLinks.istSichtbar()) {
                if (this.Rocket.getxPos() < 1920.0D && this.Rocket.getxPos() > 1680.0D) {
                    this.firespeedLinks = 8.0D;
                }

                if (this.Rocket.getxPos() < 1680.0D && this.Rocket.getxPos() > 1440.0D) {
                    this.firespeedLinks = 7.0D;
                }

                if (this.Rocket.getxPos() < 1440.0D && this.Rocket.getxPos() > 1200.0D) {
                    this.firespeedLinks = 6.0D;
                }

                if (this.Rocket.getxPos() < 1200.0D && this.Rocket.getxPos() > 960.0D) {
                    this.firespeedLinks = 5.0D;
                }

                if (this.Rocket.getxPos() < 960.0D && this.Rocket.getxPos() > 720.0D) {
                    this.firespeedLinks = 4.0D;
                }

                if (this.Rocket.getxPos() < 720.0D && this.Rocket.getxPos() > 480.0D) {
                    this.firespeedLinks = 3.0D;
                }

                if (this.Rocket.getxPos() < 480.0D && this.Rocket.getxPos() > 240.0D) {
                    this.firespeedLinks = 2.0D;
                }

                if (this.Rocket.getxPos() < 240.0D && this.Rocket.getxPos() > 0.0D) {
                    this.firespeedLinks = 1.0D;
                }
            }

            if (this.rocketHoch.istSichtbar()) {
                if (this.Rocket.getyPos() < 1080.0D && this.Rocket.getyPos() > 810.0D) {
                    this.firespeedOben = 4.0D;
                }

                if (this.Rocket.getyPos() < 810.0D && this.Rocket.getyPos() > 540.0D) {
                    this.firespeedOben = 3.0D;
                }

                if (this.Rocket.getyPos() < 540.0D && this.Rocket.getyPos() > 270.0D) {
                    this.firespeedOben = 2.0D;
                }

                if (this.Rocket.getyPos() < 270.0D && this.Rocket.getyPos() > 0.0D) {
                    this.firespeedOben = 1.0D;
                }
            }

            if (this.rocketRunter.istSichtbar()) {
                if (this.Rocket.getyPos() < 1080.0D && this.Rocket.getyPos() > 810.0D) {
                    this.firespeedUnten = 1.0D;
                }

                if (this.Rocket.getyPos() < 810.0D && this.Rocket.getyPos() > 540.0D) {
                    this.firespeedUnten = 2.0D;
                }

                if (this.Rocket.getyPos() < 540.0D && this.Rocket.getyPos() > 270.0D) {
                    this.firespeedUnten = 3.0D;
                }

                if (this.Rocket.getyPos() < 270.0D && this.Rocket.getyPos() > 0.0D) {
                    this.firespeedUnten = 4.0D;
                }
            }
        } else {
            if (this.rocket.istSichtbar()) {
                if (this.Rocket.getxPos() < 1920.0D && this.Rocket.getxPos() > 1680.0D) {
                    this.firespeedRechts = 1.5D;
                }

                if (this.Rocket.getxPos() < 1680.0D && this.Rocket.getxPos() > 1440.0D) {
                    this.firespeedRechts = 3.0D;
                }

                if (this.Rocket.getxPos() < 1440.0D && this.Rocket.getxPos() > 1200.0D) {
                    this.firespeedRechts = 4.5D;
                }

                if (this.Rocket.getxPos() < 1200.0D && this.Rocket.getxPos() > 960.0D) {
                    this.firespeedRechts = 6.0D;
                }

                if (this.Rocket.getxPos() < 960.0D && this.Rocket.getxPos() > 720.0D) {
                    this.firespeedRechts = 7.5D;
                }

                if (this.Rocket.getxPos() < 720.0D && this.Rocket.getxPos() > 480.0D) {
                    this.firespeedRechts = 9.0D;
                }

                if (this.Rocket.getxPos() < 480.0D && this.Rocket.getxPos() > 240.0D) {
                    this.firespeedRechts = 10.5D;
                }

                if (this.Rocket.getxPos() < 240.0D && this.Rocket.getxPos() > 0.0D) {
                    this.firespeedRechts = 12.0D;
                }
            }

            if (this.rocketLinks.istSichtbar()) {
                if (this.Rocket.getxPos() < 1920.0D && this.Rocket.getxPos() > 1680.0D) {
                    this.firespeedLinks = 12.0D;
                }

                if (this.Rocket.getxPos() < 1680.0D && this.Rocket.getxPos() > 1440.0D) {
                    this.firespeedLinks = 10.5D;
                }

                if (this.Rocket.getxPos() < 1440.0D && this.Rocket.getxPos() > 1200.0D) {
                    this.firespeedLinks = 9.0D;
                }

                if (this.Rocket.getxPos() < 1200.0D && this.Rocket.getxPos() > 960.0D) {
                    this.firespeedLinks = 7.5D;
                }

                if (this.Rocket.getxPos() < 960.0D && this.Rocket.getxPos() > 720.0D) {
                    this.firespeedLinks = 6.0D;
                }

                if (this.Rocket.getxPos() < 720.0D && this.Rocket.getxPos() > 480.0D) {
                    this.firespeedLinks = 4.5D;
                }

                if (this.Rocket.getxPos() < 480.0D && this.Rocket.getxPos() > 240.0D) {
                    this.firespeedLinks = 3.0D;
                }

                if (this.Rocket.getxPos() < 240.0D && this.Rocket.getxPos() > 0.0D) {
                    this.firespeedLinks = 1.5D;
                }
            }

            if (this.rocketHoch.istSichtbar()) {
                if (this.Rocket.getyPos() < 1080.0D && this.Rocket.getyPos() > 810.0D) {
                    this.firespeedOben = 6.0D;
                }

                if (this.Rocket.getyPos() < 810.0D && this.Rocket.getyPos() > 540.0D) {
                    this.firespeedOben = 4.5D;
                }

                if (this.Rocket.getyPos() < 540.0D && this.Rocket.getyPos() > 270.0D) {
                    this.firespeedOben = 3.0D;
                }

                if (this.Rocket.getyPos() < 270.0D && this.Rocket.getyPos() > 0.0D) {
                    this.firespeedOben = 1.5D;
                }
            }

            if (this.rocketRunter.istSichtbar()) {
                if (this.Rocket.getyPos() < 1080.0D && this.Rocket.getyPos() > 810.0D) {
                    this.firespeedUnten = 1.5D;
                }

                if (this.Rocket.getyPos() < 810.0D && this.Rocket.getyPos() > 540.0D) {
                    this.firespeedUnten = 3.0D;
                }

                if (this.Rocket.getyPos() < 540.0D && this.Rocket.getyPos() > 270.0D) {
                    this.firespeedUnten = 4.5D;
                }

                if (this.Rocket.getyPos() < 270.0D && this.Rocket.getyPos() > 0.0D) {
                    this.firespeedUnten = 6.0D;
                }
            }
        }

    }

    private void SchussRichtung() {
        if (this.rocket.istSichtbar() && !this.laserbeam.istSichtbar()) {
            if (this.stift.getScore() < 5.0D) {
                this.laserbeam.setzePosition(this.Rocket.getxPos() + 20.0D, this.Rocket.getyPos() - 38.0D);
            } else {
                this.laserbeam.setzePosition(this.Rocket.getxPos() + 120.0D, this.Rocket.getyPos() - 37.0D);
            }
        }

        if (this.rocketLinks.istSichtbar() && !this.laserbeam.istSichtbar()) {
            this.laserbeam.setzePosition(this.Rocket.getxPos() - 124.0D, this.Rocket.getyPos() - 36.0D);
        }

        if (this.rocketHoch.istSichtbar() && !this.laserbeamup.istSichtbar()) {
            this.laserbeamup.setzePosition(this.Rocket.getxPos() - 38.0D, this.Rocket.getyPos() - 115.0D);
        }

        if (this.rocketRunter.istSichtbar() && !this.laserbeamup.istSichtbar()) {
            if (this.stift.getScore() < 5.0D) {
                this.laserbeamup.setzePosition(this.Rocket.getxPos() - 35.0D, this.Rocket.getyPos() + 38.0D);
            } else {
                this.laserbeamup.setzePosition(this.Rocket.getxPos() - 38.0D, this.Rocket.getyPos() + 120.0D);
            }
        }

    }

    private void Schuss() {
        if (this.keyboard.istGedrueckt(' ') && this.rocket.istSichtbar() && !this.laserbeam.istSichtbar() && !this.laserbeamup.istSichtbar()) {
            this.SchussRechts = true;
        }

        if (this.keyboard.istGedrueckt(' ') && this.rocketLinks.istSichtbar() && !this.laserbeam.istSichtbar() && !this.laserbeamup.istSichtbar()) {
            this.SchussLinks = true;
        }

        if (this.keyboard.istGedrueckt(' ') && this.rocketHoch.istSichtbar() && !this.laserbeam.istSichtbar() && !this.laserbeamup.istSichtbar()) {
            this.SchussOben = true;
        } else if (this.keyboard.istGedrueckt(' ') && this.rocketRunter.istSichtbar() && !this.laserbeam.istSichtbar() && !this.laserbeamup.istSichtbar()) {
            this.SchussUnten = true;
        }

        if (this.SchussRechts) {
            this.laserbeam.setzeSichtbar(true);
            this.laserbeam.setzePosition(this.laserbeam.hPosition() + this.firespeedRechts, this.laserbeam.vPosition());
            if (this.laserbeam.hPosition() > (double)1920) {
                this.SchussRechts = false;
                this.laserbeam.setzeSichtbar(false);
            }
        }

        if (this.SchussLinks) {
            this.laserbeam.setzeSichtbar(true);
            this.laserbeam.setzePosition(this.laserbeam.hPosition() - this.firespeedLinks, this.laserbeam.vPosition());
            if (this.laserbeam.hPosition() < 0.0D) {
                this.SchussLinks = false;
                this.laserbeam.setzeSichtbar(false);
            }
        }

        if (this.SchussOben) {
            this.laserbeamup.setzeSichtbar(true);
            this.laserbeamup.setzePosition(this.laserbeamup.hPosition(), this.laserbeamup.vPosition() - this.firespeedOben);
            if (this.laserbeamup.vPosition() < 0.0D) {
                this.SchussOben = false;
                this.laserbeamup.setzeSichtbar(false);
            }
        }

        if (this.SchussUnten) {
            this.laserbeamup.setzeSichtbar(true);
            this.laserbeamup.setzePosition(this.laserbeamup.hPosition(), this.laserbeamup.vPosition() + this.firespeedUnten);
            if (this.laserbeamup.vPosition() > (double)Hilfe.monitorHoehe()) {
                this.SchussUnten = false;
                this.laserbeamup.setzeSichtbar(false);
            }
        }

    }

    public void fuehreAus() {
        this.rocket = new Bild(this.LocationRakete1);
        this.rocketLinks = new Bild(this.LocationRakete1);
        this.rocketRunter = new Bild(this.LocationRakete1);
        this.rocketHoch = new Bild(this.LocationRakete1);
        this.star = new Bild(this.LocationStern);
        this.Deathstar = new Bild(this.LocationDeathStar);
        this.Meteorite = new Bild(this.meteorite);
        this.laserbeamup = new Bild(this.laser);
        this.laserbeam = new Bild(this.laser);
        this.stein = new Meteorite();
        this.PreStar1 = new Bild(this.LocationPreStar);
        this.PreStar2 = new Bild(this.LocationPreStar);
        this.PreStar3 = new Bild(this.LocationPreStar);
        this.PreStar4 = new Bild(this.LocationPreStar);
        this.PreStar5 = new Bild(this.LocationPreStar);
        this.PreStar6 = new Bild(this.LocationPreStar);
        this.PreStar7 = new Bild(this.LocationPreStar);
        this.PreStar8 = new Bild(this.LocationPreStar);
        this.PreStar9 = new Bild(this.LocationPreStar);
        this.PreStar10 = new Bild(this.LocationPreStar);
        this.ScoreStar1 = new Bild(this.LocationStern);
        this.ScoreStar2 = new Bild(this.LocationStern);
        this.ScoreStar3 = new Bild(this.LocationStern);
        this.ScoreStar4 = new Bild(this.LocationStern);
        this.ScoreStar5 = new Bild(this.LocationStern);
        this.ScoreStar6 = new Bild(this.LocationStern);
        this.ScoreStar7 = new Bild(this.LocationStern);
        this.ScoreStar8 = new Bild(this.LocationStern);
        this.ScoreStar9 = new Bild(this.LocationStern);
        this.ScoreStar10 = new Bild(this.LocationStern);
        this.BadStar3 = new Bild(this.BadStar);
        this.BadStar6 = new Bild(this.BadStar);
        this.BadStar9 = new Bild(this.BadStar);
        this.BadStar3.setzeSichtbar(false);
        this.BadStar6.setzeSichtbar(false);
        this.BadStar9.setzeSichtbar(false);
        this.ScoreStar1.setzeSichtbar(false);
        this.ScoreStar2.setzeSichtbar(false);
        this.ScoreStar3.setzeSichtbar(false);
        this.ScoreStar4.setzeSichtbar(false);
        this.ScoreStar5.setzeSichtbar(false);
        this.ScoreStar6.setzeSichtbar(false);
        this.ScoreStar7.setzeSichtbar(false);
        this.ScoreStar8.setzeSichtbar(false);
        this.ScoreStar9.setzeSichtbar(false);
        this.ScoreStar10.setzeSichtbar(false);
        this.PreStar1.setzeGroesse(40.0D, 40.0D);
        this.PreStar2.setzeGroesse(40.0D, 40.0D);
        this.PreStar3.setzeGroesse(40.0D, 40.0D);
        this.PreStar4.setzeGroesse(40.0D, 40.0D);
        this.PreStar5.setzeGroesse(40.0D, 40.0D);
        this.PreStar6.setzeGroesse(40.0D, 40.0D);
        this.PreStar7.setzeGroesse(40.0D, 40.0D);
        this.PreStar8.setzeGroesse(40.0D, 40.0D);
        this.PreStar9.setzeGroesse(40.0D, 40.0D);
        this.PreStar10.setzeGroesse(40.0D, 40.0D);
        this.speed = 4.0D;
        this.firespeedOben = 4.0D;
        this.Meteorite.setzeGroesse(100.0D, 100.0D);
        this.laserbeam.setzeGroesse(40.0D, 80.0D);
        this.laserbeam.dreheUmMitGroessenAnpassung(90.0D);
        this.laserbeam.setzeSichtbar(false);
        this.laserbeamup.setzeGroesse(40.0D, 80.0D);
        this.laserbeamup.setzeSichtbar(false);
        this.Rocket = new rocket(540.0D, 540.0D, 0.5D);
        this.stern = new Stern();
        this.stift = new stift();
        this.fenster.setzeTitel("ROCKET");
        this.fenster.ladeBildInZeichenflaeche(this.LocationBackground);
        this.stein.pickLocation();
        this.stein.size();
        this.Meteorite.setzeGroesse(this.stein.getSize(), this.stein.getSize());
        this.stern.pickLocation();
        this.stern.setSize(100.0D * this.Rocket.getStreckung());
        this.Deathstar.setzeSichtbar(false);
        this.rocketLinks.dreheUmMitGroessenAnpassung(180.0D);
        this.rocketLinks.setzeSichtbar(false);
        this.rocketRunter.setzeSichtbar(false);
        this.rocketHoch.setzeSichtbar(false);
        this.rocketRunter.dreheUmMitGroessenAnpassung(270.0D);
        this.rocketHoch.dreheUmMitGroessenAnpassung(90.0D);
        this.star.setzeSichtbar(false);

        while(this.stift.getScore() < 10.0D) {
            if (this.stift.getScore() != 3.0D && this.stift.getScore() != 6.0D && this.stift.getScore() != 9.0D) {
                this.Deathstar.setzeSichtbar(false);
            }

            this.setFireSpeed();
            this.ScoreStar();
            this.RocketChange();
            this.star.setzeGroesse(this.stern.getSize(), this.stern.getSize());
            this.Meteorite.setzeGroesse(this.stein.getSize(), this.stein.getSize());
            this.OldRocketDimensions();
            this.PositionRocket();
            this.Meteorite.setzePosition((double)this.stein.getX(), (double)this.stein.getY());
            this.star.setzePosition((double)(this.stern.getX() - 4), (double)(this.stern.getY() - 5));
            this.KollisionGut();
            this.KollisionSchlecht();
            if (this.keyboard.istGedrueckt('\u001b')) {
                System.exit(0);
            }

            this.Movement();
            this.Fenstersmoothness();
            this.Schuss();
            this.SchussRichtung();
        }

        this.Erase();

        while(!this.keyboard.istGedrueckt('\u001b')) {
            this.stift.end();
        }

        System.exit(0);
    }

    public void game() {
        Bild Bewegung = new Bild("res/Bewegen.png");
        Bild Space = new Bild("res/Space.png");
        Bild Steuerung = new Bild("res/Steuerung.png");
        Bild Rechteck = new Bild("res/Rechteck 1.png");
        Bild HelpMeteorit = new Bild("res/Anleitung_Meteorit.png");
        Bild HelpStern = new Bild("res/Anleitung_Stern.png");
        Bild startscreen = new Bild("res/startscreen.png");
        Rechteck.setzeGroesse(30.0D, 30.0D);
        HelpStern.setzeGroesse(254.0D, 151.0D);
        HelpMeteorit.setzeGroesse(254.0D, 151.0D);
        Rechteck.setzeSichtbar(false);
        HelpStern.setzeSichtbar(false);
        HelpMeteorit.setzeSichtbar(false);
        Space.setzeSichtbar(false);
        Bewegung.setzeSichtbar(false);

        while(true) {
            while(!this.keyboard.istGedrueckt(' ')) {
                HelpStern.setzePosition((double)(this.fenster.breite() + 170 - this.fenster.breite()), (double)(this.fenster.hoehe() - (this.fenster.hoehe() - 100)));
                HelpMeteorit.setzePosition((double)(this.fenster.breite() + 170 - this.fenster.breite()), (double)(this.fenster.hoehe() - (this.fenster.hoehe() - 280)));
                Bewegung.setzePosition((double)(this.fenster.breite() + 180 - this.fenster.breite()), (double)(this.fenster.hoehe() - (this.fenster.hoehe() - 470)));
                Space.setzePosition((double)(this.fenster.breite() + 40 - this.fenster.breite()), (double)(this.fenster.hoehe() - (this.fenster.hoehe() - 720)));
                Steuerung.setzePosition((double)(this.fenster.breite() + 170 - this.fenster.breite()), (double)(this.fenster.hoehe() - (this.fenster.hoehe() - 900)));
                Rechteck.setzePosition((double)this.maus.hPosition(), (double)this.maus.vPosition());
                if (Steuerung.kollisionErkanntMit(Rechteck)) {
                    Space.setzeSichtbar(true);
                    Space.setzeTransparenz(true);

                    while(this.d <= 1.0D) {
                        Space.setzeTransparenzGrad(this.d);
                        this.d += 0.025D;
                        Hilfe.warte(5L);
                    }

                    Bewegung.setzeSichtbar(true);
                    Bewegung.setzeTransparenz(true);

                    while(this.e <= 1.0D) {
                        Bewegung.setzeTransparenzGrad(this.e);
                        this.e += 0.025D;
                        Hilfe.warte(5L);
                    }

                    HelpMeteorit.setzeSichtbar(true);
                    HelpMeteorit.setzeTransparenz(true);

                    while(this.f <= 1.0D) {
                        HelpMeteorit.setzeTransparenzGrad(this.f);
                        this.f += 0.025D;
                        Hilfe.warte(5L);
                    }

                    HelpStern.setzeSichtbar(true);
                    HelpStern.setzeTransparenz(true);

                    while(this.h <= 1.0D) {
                        HelpStern.setzeTransparenzGrad(this.h);
                        this.h += 0.025D;
                        Hilfe.warte(5L);
                    }
                } else {
                    if (Space.istSichtbar() && Bewegung.istSichtbar() && HelpMeteorit.istSichtbar() && HelpStern.istSichtbar()) {
                        while(this.d > 0.0D) {
                            Space.setzeTransparenzGrad(this.d);
                            this.d -= 0.025D;
                            Hilfe.warte(5L);
                        }

                        this.d = 0.0D;
                        Space.setzeSichtbar(false);

                        while(this.e > 0.0D) {
                            Bewegung.setzeTransparenzGrad(this.e);
                            this.e -= 0.025D;
                            Hilfe.warte(5L);
                        }

                        this.e = 0.0D;
                        Bewegung.setzeSichtbar(false);

                        while(this.f > 0.0D) {
                            HelpMeteorit.setzeTransparenzGrad(this.f);
                            this.f -= 0.025D;
                            Hilfe.warte(5L);
                        }

                        this.f = 0.0D;
                        HelpMeteorit.setzeSichtbar(false);
                    }

                    while(this.h > 0.0D) {
                        HelpStern.setzeTransparenzGrad(this.h);
                        this.h -= 0.025D;
                        Hilfe.warte(5L);
                    }

                    this.h = 0.0D;
                    HelpMeteorit.setzeSichtbar(false);
                }
            }

            if (this.keyboard.istGedrueckt('\u001b')) {
                System.exit(0);
            }

            Hilfe.kurzePause();
            startscreen.setzeGroesse((double)this.fenster.breite(), (double)this.fenster.hoehe());
            startscreen.setzeSichtbar(false);
            Steuerung.setzeSichtbar(false);
            Rechteck.setzeSichtbar(false);
            Bewegung.setzeSichtbar(false);
            Space.setzeSichtbar(false);
            HelpMeteorit.setzeSichtbar(false);
            HelpStern.setzeSichtbar(false);
            this.fuehreAus();
            return;
        }
    }

    public static void main(String[] args) {
        MAINnormal Rocket = new MAINnormal();
        Rocket.game();
    }
}