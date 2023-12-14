import { BaseEntity, Column, Entity, ManyToOne, OneToMany, PrimaryGeneratedColumn, TableForeignKey } from "typeorm";
import { Feed } from "./Feed";

@Entity("FeedItem")
export class FeedItem extends BaseEntity{
    @PrimaryGeneratedColumn("increment") id: number;
    @Column("text") titulo: string;
    @Column("text") descripcion: string;
    @Column("boolean") visited: boolean;
    @ManyToOne( ()=> Feed, (feed)=>feed.feedItems)
    feed: Feed;
}