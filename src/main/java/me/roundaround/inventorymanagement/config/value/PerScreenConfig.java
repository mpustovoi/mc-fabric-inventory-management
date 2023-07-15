package me.roundaround.inventorymanagement.config.value;

import me.roundaround.roundalib.config.value.Position;

import java.util.HashMap;
import java.util.function.Function;

public class PerScreenConfig extends HashMap<String, PerScreenConfig.ScreenConfig> {
  public static HashMap<String, HashMap<String, String>> serialize(PerScreenConfig config) {
    HashMap<String, HashMap<String, String>> serialized = new HashMap<>();
    for (Entry<String, ScreenConfig> entry : config.entrySet()) {
      serialized.put(entry.getKey(), ScreenConfig.serialize(entry.getValue()));
    }
    return serialized;
  }

  public static PerScreenConfig deserialize(HashMap<String, HashMap<String, String>> serialized) {
    PerScreenConfig config = new PerScreenConfig();
    for (Entry<String, HashMap<String, String>> entry : serialized.entrySet()) {
      config.put(entry.getKey(), ScreenConfig.deserialize(entry.getValue()));
    }
    return config;
  }

  public static class ScreenConfig {
    private ButtonVisibility playerSideSortVisibility;
    private ButtonVisibility playerSideTransferVisibility;
    private ButtonVisibility containerSideSortVisibility;
    private ButtonVisibility containerSideTransferVisibility;
    private Position playerSideOffset;
    private Position containerSideOffset;

    public ScreenConfig(
        ButtonVisibility playerSideSortVisibility,
        ButtonVisibility playerSideTransferVisibility,
        ButtonVisibility containerSideSortVisibility,
        ButtonVisibility containerSideTransferVisibility,
        Position playerSideOffset,
        Position containerSideOffset) {
      this.playerSideSortVisibility = playerSideSortVisibility;
      this.playerSideTransferVisibility = playerSideTransferVisibility;
      this.containerSideSortVisibility = containerSideSortVisibility;
      this.containerSideTransferVisibility = containerSideTransferVisibility;
      this.playerSideOffset = playerSideOffset;
      this.containerSideOffset = containerSideOffset;
    }

    public ScreenConfig(ScreenConfig other) {
      this.playerSideSortVisibility = other.playerSideSortVisibility;
      this.playerSideTransferVisibility = other.playerSideTransferVisibility;
      this.containerSideSortVisibility = other.containerSideSortVisibility;
      this.containerSideTransferVisibility = other.containerSideTransferVisibility;
      this.playerSideOffset = other.playerSideOffset;
      this.containerSideOffset = other.containerSideOffset;
    }

    public ButtonVisibility getPlayerSideSortVisibility() {
      return playerSideSortVisibility;
    }

    public ButtonVisibility getPlayerSideTransferVisibility() {
      return playerSideTransferVisibility;
    }

    public ButtonVisibility getContainerSideSortVisibility() {
      return containerSideSortVisibility;
    }

    public ButtonVisibility getContainerSideTransferVisibility() {
      return containerSideTransferVisibility;
    }

    public Position getPlayerSideOffset() {
      return playerSideOffset;
    }

    public Position getContainerSideOffset() {
      return containerSideOffset;
    }

    public void setPlayerSideSortVisibility(ButtonVisibility playerSideSortVisibility) {
      this.playerSideSortVisibility = playerSideSortVisibility;
    }

    public void clearPlayerSideSortVisibility() {
      this.playerSideSortVisibility = null;
    }

    public void setPlayerSideTransferVisibility(ButtonVisibility playerSideTransferVisibility) {
      this.playerSideTransferVisibility = playerSideTransferVisibility;
    }

    public void clearPlayerSideTransferVisibility() {
      this.playerSideTransferVisibility = null;
    }

    public void setContainerSideSortVisibility(ButtonVisibility containerSideSortVisibility) {
      this.containerSideSortVisibility = containerSideSortVisibility;
    }

    public void clearContainerSideSortVisibility() {
      this.containerSideSortVisibility = null;
    }

    public void setContainerSideTransferVisibility(
        ButtonVisibility containerSideTransferVisibility) {
      this.containerSideTransferVisibility = containerSideTransferVisibility;
    }

    public void clearContainerSideTransferVisibility() {
      this.containerSideTransferVisibility = null;
    }

    public void setPlayerSideOffset(Position playerSideOffset) {
      this.playerSideOffset = playerSideOffset;
    }

    public void clearPlayerSideOffset() {
      this.playerSideOffset = null;
    }

    public void setContainerSideOffset(Position containerSideOffset) {
      this.containerSideOffset = containerSideOffset;
    }

    public void clearContainerSideOffset() {
      this.containerSideOffset = null;
    }

    public static HashMap<String, String> serialize(ScreenConfig config) {
      HashMap<String, String> serialized = new HashMap<>();

      if (config.playerSideSortVisibility != null) {
        serialized.put("playerSideSortVisibility", config.playerSideSortVisibility.getId());
      }
      if (config.playerSideTransferVisibility != null) {
        serialized.put("playerSideTransferVisibility", config.playerSideTransferVisibility.getId());
      }
      if (config.containerSideSortVisibility != null) {
        serialized.put("containerSideSortVisibility", config.containerSideSortVisibility.getId());
      }
      if (config.containerSideTransferVisibility != null) {
        serialized.put("containerSideTransferVisibility",
            config.containerSideTransferVisibility.getId());
      }
      if (config.playerSideOffset != null) {
        serialized.put("playerSideOffset", Position.serialize(config.playerSideOffset));
      }
      if (config.containerSideOffset != null) {
        serialized.put("containerSideOffset", Position.serialize(config.containerSideOffset));
      }

      return serialized;
    }

    public static ScreenConfig deserialize(HashMap<String, String> serialized) {
      return new ScreenConfig(getOrNull("playerSideSortVisibility",
          serialized,
          ButtonVisibility::fromId),
          getOrNull("playerSideTransferVisibility", serialized, ButtonVisibility::fromId),
          getOrNull("containerSideSortVisibility", serialized, ButtonVisibility::fromId),
          getOrNull("containerSideTransferVisibility", serialized, ButtonVisibility::fromId),
          getOrNull("playerSideOffset", serialized, Position::deserialize),
          getOrNull("containerSideOffset", serialized, Position::deserialize));
    }

    private static <T> T getOrNull(
        String key, HashMap<String, String> serialized, Function<String, T> getter) {
      String value = serialized.get(key);
      if (value == null) {
        return null;
      }
      return getter.apply(value);
    }
  }
}
