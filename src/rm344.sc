;;; Sierra Script 1.0 - (do not remove this comment)
(script# 344)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use EcoRoom)
(use n819)
(use RTRandCycle)
(use Sound)
(use Cycle)
(use Obj)
(use View)

(public
	rm344 0
)

(instance rope0 of Prop
	(properties
		view 340
		loop 0
		cel 0
		x 252
		y 0
		priority -1
	)
)
(instance rope1 of Prop
	(properties
		view 340
		loop 0
		cel 0
		x 252
		y 39
		priority -1
	)
)
(instance rope2 of Prop
	(properties
		view 340
		loop 0
		cel 0
		x 252
		y 78
		priority -1
	)
)
(instance rope3 of Prop
	(properties
		view 340
		loop 0
		cel 0
		x 252
		y 117
		priority -1
	)
)
(instance rope4 of Prop
	(properties
		view 340
		loop 0
		cel 0
		x 252
		y 156
		priority -1
	)
)
(instance rope5 of Prop
	(properties
		view 340
		loop 0
		cel 0
		x 252
		y 195
		priority -1
	)
)

(procedure (localproc_0022 &tmp temp0)
	(= temp0 0)
	(while (< temp0 5)
		(DrawCel 340 0 0 252 (* temp0 39) -1)
		(++ temp0)
	)
)

(instance rm344 of EcoRoom
	(properties
		picture 340
		style $0007
		north 660
		south 620
	)
	
	(method (init)
		(self setRegions: 51)
		(gEgo
			init:
			posn: 160 -30 0
			view: 805
			setLoop: 2
			ignoreHorizon: 1
		)
		(if (not (proc819_5 96)) ;harpoon dislodged
			(rope0 init: addToPic:)
			(rope1 init: addToPic:)
			(rope2 init: addToPic:)
			(rope3 init: addToPic:)
			(rope4 init: addToPic:)
			(rope5 init: addToPic:)
		)
		(if (not (proc819_5 85))
			(gEgo setScript: whaleSoundScript)
		)
		(self setScript: enterRmScript)
		(= picture (= picture 341))
		(= style (= style -32759))
		(super init:)
		(gLongSong number: 332 loop: -1 play:)
		;(if (not (proc819_5 96)) (localproc_0022))
	)
	
	(method (doit)
		(super doit: &rest)
		(Palette palANIMATE 160 207 12)
;;;		(if (and (GameIsRestarting) (not (proc819_5 96)))
;;;			(localproc_0022)
;;;		)
	)
)

(instance enterRmScript of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0 (= cycles (= cycles 3)))
			(1
				(cond 
					((proc819_5 96) (= cycles (= cycles 1)))
					(
						(and
							(== gSouth (global2 south?))
							(not (proc819_5 124))
						)
						(EcoNarrator init: 1 0 0 1 self)
					)
					((== gSouth (global2 south?)) (EcoNarrator init: 1 0 0 4 self))
					(else (EcoNarrator init: 1 0 0 2 self))
				)
			)
			(2
				(switch gSouth
					(640
						(gEgo posn: 160 -30 0 setMotion: MoveTo 160 226 self)
					)
					(else 
						(gEgo posn: 160 220 0 setMotion: MoveTo 160 -45 self)
					)
				)
			)
			(3
				(if (not (proc819_3 124))
					(EcoNarrator init: 1 0 0 3 self)
				else
					(= cycles (= cycles 1))
				)
			)
			(4
				(gEgo setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance whaleSoundScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0 (= seconds (= seconds 4)))
			(1
				(= state (= state -1))
				(whaleSound loop: 1 play: self)
			)
		)
	)
)

(instance whaleSound of Sound
	(properties
		number 645
	)
)
