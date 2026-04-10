import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // ✔ 1. All bogies valid
    @Test
    void testSafety_AllBogiesValid() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistManagementApp.GoodsBogie("Open", "Coal"),
                new TrainConsistManagementApp.GoodsBogie("Box", "Grain")
        );

        assertTrue(TrainConsistManagementApp.isTrainSafe(bogies));
    }

    // ✔ 2. Cylindrical with invalid cargo
    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal") // violation
        );

        assertFalse(TrainConsistManagementApp.isTrainSafe(bogies));
    }

    // ✔ 3. Non-cylindrical bogies allowed any cargo
    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Open", "Coal"),
                new TrainConsistManagementApp.GoodsBogie("Box", "Grain")
        );

        assertTrue(TrainConsistManagementApp.isTrainSafe(bogies));
    }

    // ✔ 4. Mixed bogies with violation
    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal") // violation
        );

        assertFalse(TrainConsistManagementApp.isTrainSafe(bogies));
    }

    // ✔ 5. Empty list
    @Test
    void testSafety_EmptyBogieList() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = new ArrayList<>();

        assertTrue(TrainConsistManagementApp.isTrainSafe(bogies));
    }
}