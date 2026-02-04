package frc.robot.subsystems;

import com.ctre.phoenix6.signals.NeutralModeValue;

public class VictorSPX {
//Should Victor SPX be an int, float, boolean, string?
    public VictorSPX(int i) {}

    public void setNeutralMode(NeutralModeValue brake) {
        throw new UnsupportedOperationException("Unimplemented method 'setNeutralMode'");
    }

    public void setInverted(boolean b) {
        throw new UnsupportedOperationException("Unimplemented method 'setInverted'");
    }

    public static void set(String percentoutput, int i) {
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    public double get() {
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    public void set(double speed) {
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }
    public void follow(TalonSRX m_rightLeader) {
        throw new UnsupportedOperationException("Unimplemented method 'follow'");
    }

    /*public void follow(TalonSRX m_Leader) {
        throw new UnsupportedOperationException("Unimplemented method 'follow'");
    }*/

}
