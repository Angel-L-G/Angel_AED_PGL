import { DataSource } from "typeorm";
import { Feed } from "../entities/Feed";
import { FeedItem } from "../entities/FeedItem";

export const dataSource = new DataSource(
    {
        database: "personadb.db",
        entities: [Feed, FeedItem],
        location: "default",
        logging: [],
        synchronize: true,
        type: "react-native"
    }
);

export const FeedRepository = dataSource.getRepository(Feed);
export const FeedItemRepository = dataSource.getRepository(FeedItem);