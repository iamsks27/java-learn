package com.shivam.learn.reflection.graph;

import com.shivam.learn.reflection.graph.databases.Database;

import java.util.*;

import static com.shivam.learn.reflection.graph.annotations.Annotations.*;

/**
 * @author sksingh created on 14/01/24
 */
public class BestGamesFinder {

    private final Database database = new Database();

    @Operation("All-Games")
    public Set<String> getAllGames() {
        return database.readAllGames();
    }

    @Operation("Game-To-Price")
    public Map<String, Float> getGameToPrice(@DependsOn("All-Games") Set<String> games) {
        return database.readGameToPrice(games);
    }

    @Operation("Game-To-Rating")
    public Map<String, Float> getGameToRating(@DependsOn("All-Games") Set<String> games) {
        return database.readGameToRatings(games);
    }

    @Operation("Score-To-Game")
    public SortedMap<Double, String> scoreGames(
            @DependsOn("Game-To-Price") Map<String, Float> gameToPrice,
            @DependsOn("Game-To-Rating") Map<String, Float> gameToRating
    ) {
        SortedMap<Double, String> gameToScore = new TreeMap<>(Collections.reverseOrder());

        for (String game : gameToPrice.keySet()) {
            double score = (double) gameToRating.get(game) / gameToPrice.get(game);
            gameToScore.put(score, game);
        }

        return gameToScore;
    }

    @FinalResult
    public List<String> getTopGames(@DependsOn("Score-To-Game") SortedMap<Double, String> gameToScore) {
        return new ArrayList<>(gameToScore.values());
    }
}
