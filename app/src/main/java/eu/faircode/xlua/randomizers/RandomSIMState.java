package eu.faircode.xlua.randomizers;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import eu.faircode.xlua.randomizers.elements.DataNameValueElement;
import eu.faircode.xlua.randomizers.elements.DataNullElement;
import eu.faircode.xlua.randomizers.elements.ISpinnerElement;

public class RandomSIMState implements IRandomizer {
    private final List<ISpinnerElement> dataStates = new ArrayList<>();
    public RandomSIMState() {
        dataStates.add(DataNullElement.EMPTY_ELEMENT);
        dataStates.add(DataNameValueElement.create("SIM_STATE_UNKNOWN", 0));
        dataStates.add(DataNameValueElement.create("SIM_STATE_ABSENT", 1));
        dataStates.add(DataNameValueElement.create("SIM_STATE_PIN_REQUIRED", 2));
        dataStates.add(DataNameValueElement.create("SIM_STATE_PUK_REQUIRED", 3));
        dataStates.add(DataNameValueElement.create("SIM_STATE_NETWORK_LOCKED", 4));
        dataStates.add(DataNameValueElement.create("SIM_STATE_READY", 5));
        dataStates.add(DataNameValueElement.create("SIM_STATE_NOT_READY", 6));
        dataStates.add(DataNameValueElement.create("SIM_STATE_PERM_DISABLED", 7));
        dataStates.add(DataNameValueElement.create("SIM_STATE_CARD_IO_ERROR", 8));
        dataStates.add(DataNameValueElement.create("SIM_STATE_CARD_RESTRICTED", 9));
    }

    @Override
    public boolean isSetting(String setting) { return setting.equalsIgnoreCase(getSettingName()) || setting.equalsIgnoreCase("gsm.sim.state.number"); }

    @Override
    public String getSettingName() {  return "gsm.sim.state"; }

    @Override
    public String getName() {
        return "SIM State";
    }

    @Override
    public String getID() {
        return "%gsm_sim_state%";
    }

    @Override
    public String generateString() {
        ISpinnerElement el = dataStates.get(ThreadLocalRandom.current().nextInt(1, dataStates.size()));
        return el.getValue();
    }

    @Override
    public int generateInteger() { return 0; }

    @Override
    public List<ISpinnerElement> getOptions() { return this.dataStates; }

    @NonNull
    @Override
    public String toString() { return getName(); }
}
