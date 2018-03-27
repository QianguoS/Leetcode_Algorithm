public class stepDector {
    public void step(double curValue){
        boolean motiveState = true;
        double lstValue = 0;
        double range = 0.1;
        double oriValue = 0;
        int step = 0;
        //向上加速的状态
        if (motiveState == true) {
            if (curValue >= lstValue) lstValue = curValue;
            else {
                //检测到一次峰值
                if (Math.abs(curValue - lstValue) > range) {
                    oriValue = curValue;
                    motiveState = false;
                }
            }
        }
        //向下加速的状态
        if (motiveState == false) {
            if (curValue <= lstValue) lstValue = curValue;
            else {
                if (Math.abs(curValue - lstValue) > range) {
                    //检测到一次峰值
                    oriValue = curValue;
                    step++;
                    motiveState = true;
                }
            }
        }
    }
}
