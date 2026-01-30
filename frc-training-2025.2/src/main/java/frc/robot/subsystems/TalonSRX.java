package frc.robot.subsystems;

import com.ctre.phoenix6.signals.NeutralModeValue;

public class TalonSRX{

    public TalonSRX(int i) {
    }

  

    public void setInverted(boolean b) {
     
        throw new UnsupportedOperationException("Unimplemented method 'setInverted'");
    }

    public static void set(String percentoutput, int i) {
    
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    public void follow(TalonSRX m_Leader) {
        throw new UnsupportedOperationException("Unimplemented method 'follow'");
    }

    public double get() {

        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    public void set(double speed) {
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    public double getMotorOutputPercent() {

        throw new UnsupportedOperationException("Unimplemented method 'getMotorOutputPercent'");
    }

    public void setNeutralMode(NeutralModeValue brake) {
        throw new UnsupportedOperationException("Unimplemented method 'setNeutralMode'");
    }



	public double getSelectedSensorPosition() {
		throw new UnsupportedOperationException("Unimplemented method 'getSelectedSensorPosition'");
	}

}
