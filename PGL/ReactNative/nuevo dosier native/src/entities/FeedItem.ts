import { BaseEntity, Column, Entity, ManyToOne, OneToMany, PrimaryGeneratedColumn, TableForeignKey } from "typeorm";
import { Feed } from "./Feed";

@Entity("FeedItem")
export class FeedItem extends BaseEntity{
    @PrimaryGeneratedColumn() id: number;
    @Column("title") titulo: string;
    @Column("descripcion") descripcion: string;
    @Column("url") url: string;
    @ManyToOne( ()=> Feed, (feed)=>feed.id)
    feed: Feed;
}