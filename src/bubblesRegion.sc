;;; Sierra Script 1.0 - (do not remove this comment)
(script# 51)
(include sci.sh)
(use Main)
(use EcoFeature)
(use Cycle)
(use Game)
(use Obj)

(public
	bubblesRegion 0
)

(local
	[local0 8] = [9 -10 -12 -10 14 -18]
	[local8 8] = [-13 -13 -4 -21 -2 -3 -18 -18]
)
(class bubblesRegion of Rgn
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
		seconds 6
		lastSeconds 0
	)
	
	(method (init)
		(super init: &rest)
		(bubbles init:)
	)
	
	(method (doit &tmp theLastSeconds)
		(if
			(and
				seconds
				(!= lastSeconds (= theLastSeconds (GetTime 1)))
			)
			(= lastSeconds theLastSeconds)
			(if (not (-- seconds))
				(= seconds 6)
				(if
					(and
						(not (& (gEgo signal?) $0008))
						(proc999_5 (gEgo view?) 802 805)
					)
					(bubbles cue:)
				)
			)
		)
		(super doit:)
	)
	
	(method (newRoom)
		(= initialized (= keep 0))
		(super newRoom: &rest)
	)
)

(instance bubbles of EcoProp
	(properties
		view 807
		cel 6
		signal $6000
	)
	
	(method (cue &tmp temp0)
		(if (== (gEgo view?) 802)
			(self
				setLoop: (not (proc999_5 (gEgo loop?) 1 4 7))
				x: (+ (gEgo x?) [local0 (gEgo loop?)])
				y: (- (+ (gEgo y?) [local8 (gEgo loop?)]) (gEgo z?))
			)
		else
			(self
				setLoop: (= temp0 (not (proc999_5 (gEgo loop?) 1 5 7)))
				x: (+ (- (gEgo x?) 7) (* (not temp0) 14))
				y: (- (+ (gEgo y?) -17) (gEgo z?))
			)
		)
		(self setPri: (gEgo priority?) cel: 0 setCycle: End)
	)
)
